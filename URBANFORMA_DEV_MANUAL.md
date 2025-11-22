# UrbanForma 开发手册

本手册整合了 UrbanForma 模组的开发指南、项目结构说明及方块参考，旨在为开发者提供详尽的一站式参考资料。

---

## 1. 项目概况 (Overview)

- **模组名称**: UrbanForma (都市构方)
- **模组 ID**: `urbanforma`
- **加载器**: Forge (1.20.1)
- **主类**: `com.urbanforma.UrbanForma`
- **项目定位**: 这是一个专注于现代城市建设的装饰性模组，提供大量高精度的道路标线、路缘石以及丰富的彩色建筑方块。
- **开发原则**:
    1. **一致性**: 优先遵循现有的代码风格和命名规范，保持代码库的整洁。
    2. **参考性**: 仅在创建全新内容类型（如新的实体或复杂的方块逻辑）时，参考 [Boson 教程](https://boson.v2mcdev.com/) 的设计概念。
    3. **本地化**: 所有新添加的内容必须同步更新 `zh_cn.json` 语言文件。

---

## 2. 项目结构与资源 (Structure & Resources)

### 2.1 详细目录结构

项目遵循标准的 Forge Mod 结构，以下是关键目录的详细说明：

```
d:\UrbanForma
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── urbanforma
│   │   │           ├── block           // [核心] 自定义方块类存放处
│   │   │           │   ├── HeightRoadBlock.java        // 自定义高度方块（用于路缘石等）
│   │   │           │   ├── DirectionalRoadBlock.java   // 带方向的方块（用于标线等）
│   │   │           │   └── ...
│   │   │           ├── item            // 自定义物品类存放处
│   │   │           ├── ModBlocks.java  // [核心] 方块注册中心，所有方块在此实例化
│   │   │           ├── ModItems.java   // 物品注册中心，通常引用 ModBlocks 中的方块
│   │   │           ├── ModCreativeTabs.java // 创造模式物品栏配置
│   │   │           └── UrbanForma.java // 模组主类，负责事件总线注册和初始化
│   │   └── resources
│   │       ├── META-INF
│   │       │   └── mods.toml       // 模组核心元数据 (定义 ModID, 版本, 依赖关系)
│   │       ├── assets
│   │       │   └── urbanforma
│   │       │       ├── blockstates // [资源] 定义方块在不同状态（如旋转、变种）下使用哪个模型
│   │       │       ├── lang        // [资源] 语言文件 (zh_cn.json 是必须维护的)
│   │       │       ├── models
│   │       │       │   ├── block   // [资源] 方块模型定义 (几何形状、纹理映射)
│   │       │       │   └── item    // [资源] 物品模型定义 (通常父级指向 block 模型)
│   │       │       └── textures
│   │       │           └── block   // [资源] 方块的 PNG 贴图文件
│   │       └── data                // (可选) 数据包内容，如配方(recipes)、掉落表(loot_tables)
├── build.gradle                    // Gradle 构建脚本，定义依赖和构建任务
└── README.md                       // 项目说明文档
```

### 2.2 资源文件详解

添加一个新方块时，必须完整创建以下 5 类资源文件，缺一不可：

| 资源类型 | 路径示例 (`assets/urbanforma/...`) | 详细说明 |
| :--- | :--- | :--- |
| **Blockstate** | `blockstates/my_block.json` | **状态映射**。定义方块的 `variants`（变种）。对于普通方块，通常映射到单一模型；对于方向性方块，需定义 `facing=north` 等状态对应的旋转角度 (`y` 轴旋转)。 |
| **Block Model** | `models/block/my_block.json` | **几何模型**。定义方块的形状（`parent`）和纹理（`textures`）。普通方块通常继承 `block/cube_all`；自定义形状方块需指定具体的父模型或自定义元素。 |
| **Item Model** | `models/item/my_block.json` | **物品展示**。定义方块在玩家手中、物品栏或掉落时的外观。通常直接继承对应的 Block Model (`parent: urbanforma:block/my_block`)。 |
| **Texture** | `textures/block/my_block.png` | **纹理贴图**。实际的图片文件。建议使用 16x16 像素的标准 Minecraft 风格贴图。 |
| **Lang (CN)** | `lang/zh_cn.json` | **本地化名称**。格式为 `"block.urbanforma.registry_name": "中文名称"`。请务必保持键名与注册名一致。 |

---

## 3. 开发指南 (Development Guide)

### 3.1 代码风格与命名规范

为了保持代码库的整洁和可维护性，请严格遵守以下规范：

- **注册名 (Registry Name)**:
  - 格式: 全小写，下划线分隔 (snake_case)。
  - 示例: `white_building_block`, `road_white_line_h1`
  - 作用: 游戏内部的唯一标识符，用于 `/give` 指令和资源文件路径。
- **Java 常量名 (RegistryObject)**:
  - 格式: 全大写，下划线分隔 (UPPER_SNAKE_CASE)。
  - 示例: `WHITE_BUILDING_BLOCK`, `ROAD_WHITE_LINE_H1`
  - 作用: 在 Java 代码中引用该方块的静态常量。
- **类名 (Class Name)**:
  - 格式: 大驼峰 (PascalCase)。
  - 示例: `HeightRoadBlock`, `DirectionalRoadBlock`
  - 作用: 定义方块逻辑的 Java 类。

### 3.2 注册系统详解

本项目使用 Forge 推荐的 **`DeferredRegister`** 机制。这是一种线程安全的注册方式，确保在正确的生命周期阶段注册对象。

- **方块注册 (`ModBlocks`)**: 使用 `DeferredRegister<Block> BLOCKS`。
- **物品注册 (`ModItems`)**: 使用 `DeferredRegister<Item> ITEMS`。注意：大多数方块都需要注册对应的 `BlockItem` 才能在物品栏显示。
- **创造模式物品栏 (`ModCreativeTabs`)**: 使用 `DeferredRegister<CreativeModeTab>`。

### 3.3 添加新方块的完整流程

请按顺序执行以下步骤：

#### 步骤 1: 在 `ModBlocks.java` 中注册方块

使用现有的辅助方法来简化代码：

- `registerBasicBlock(name)`: 注册一个标准的、无特殊功能的建筑方块。
- `registerGlowingBlock(name)`: 注册一个发光等级为 15 的方块。
- `registerSlabBlock(name)`: 注册对应的半砖版本。
- `registerStairBlock(name, baseBlock)`: 注册对应的楼梯版本（需传入基础方块以继承材质）。
- `registerHeightRoadBlock(name, height)`: 注册自定义高度的道路方块（高度单位为像素，范围 0-16）。
- `registerDirectionalRoadBlock(name)`: 注册带方向的道路标线方块。

```java
// 示例代码
public static final RegistryObject<Block> MY_NEW_BLOCK = registerBasicBlock("my_new_block");
```

#### 步骤 2: 在 `ModCreativeTabs.java` 中添加到物品栏

找到对应的 `displayItems` Lambda 表达式，使用 `output.accept` 添加新方块。

```java
// 示例：添加到基础物品栏
if (event.getTabKey() == ModCreativeTabs.URBANFORMA_BASE_TAB.getKey()) {
    output.accept(ModBlocks.MY_NEW_BLOCK.get());
}
```

#### 步骤 3: 创建资源文件

根据 2.2 节的说明，创建对应的 JSON 和 PNG 文件。

### 3.4 构建与测试 (Build & Test)

在项目根目录下使用终端执行以下指令：

- **构建模组**:

    ```powershell
    cd d:\UrbanForma; gradle build
    ```

    此命令会编译代码并生成 `.jar` 文件，通常位于 `build/libs` 目录下。

- **启动测试客户端**:

    ```powershell
    cd d:\UrbanForma; .\gradlew runClient
    ```

    此命令会启动一个独立的 Minecraft 客户端环境，用于测试模组功能。

---

## 4. 创造模式物品栏 (Creative Tabs)

为了方便玩家查找，本项目将方块细分为 3 个专属的创造模式物品栏：

### 4.1 都市构方基础 (UrbanForma Base)

- **ID**: `a_1_urbanforma_base`
- **代码引用**: `ModCreativeTabs.URBANFORMA_BASE_TAB`
- **设计目的**: 包含所有用于建筑主体的方块。
- **包含内容**:
  - **纯色系列**: 白色、黑色等基础色。
  - **灰度系列**: 从亮灰到暗灰的精细渐变，满足不同光影需求。
  - **和色/传统色系列**: 包含 72+ 种具有东方韵味的颜色（如桜色、海松色、利休鼠等），每种颜色都有普通、发光、半砖、楼梯变种。

### 4.2 都市构方道路 (UrbanForma Road)

- **ID**: `a_2_urbanforma_road`
- **代码引用**: `ModCreativeTabs.URBANFORMA_ROAD_TAB`
- **设计目的**: 包含所有用于构建城市道路系统的方块。
- **包含内容**:
  - **路面基底**: 不同深浅的沥青/混凝土路面。
  - **交通标线**: 斑马线、车道线、停止线、导向箭头等（均支持方向旋转）。
  - **立体交通设施**: 路缘石（不同高度）、安全岛边缘等。

### 4.3 都市构方其他 (UrbanForma Other)

- **ID**: `a_3_urbanforma_other`
- **代码引用**: `ModCreativeTabs.URBANFORMA_OTHER_TAB`
- **设计目的**: 预留给特殊道具、工具或不属于上述两类的杂项方块。

---

## 5. 方块参考 (Block Reference)

### 5.1 基础建筑方块命名规则

为了保持 ID 的整洁，我们使用简写前缀：

- **普通方块**: `[前缀]_bb` (Building Block)
- **发光方块**: `[前缀]_gbb` (Glowing Building Block)
- **半砖**: `[前缀]_sbb` (Slab Building Block)
- **楼梯**: `[前缀]_stbb` (Stairs Building Block)

**前缀示例**:

- `w_`: White (白色)
- `lg_1_`: Light Gray 1 (亮灰1)
- `n_hb_`: 浓灰白 (Nong Hui Bai - 拼音首字母或英文缩写)

### 5.2 道路系统详解

#### 基础路面

用于铺设大面积的道路。

- `r_gray`: 标准灰色沥青路面。
- `r_white`: 白色路面（如人行道）。

#### 道路标线 (Directional)

此类方块继承自 **`DirectionalRoadBlock`**。

- **特性**: 放置时会自动根据玩家的朝向进行水平旋转（北/南/东/西）。
- **用途**: 确保标线（如箭头、文字、斑马线）的方向正确。
- **ID 规律**: 通常以 `r_wl` (Road White Line) 开头，后跟数字或描述。

#### 高度路面 (Height Road)

此类方块继承自 **`HeightRoadBlock`**。

- **特性**: 拥有自定义的碰撞箱高度和视觉高度。
- **高度换算**: 1 个 Minecraft 方块高度 = 16 像素。
  - `h1` = 2 像素
  - `h2` = 4 像素
  - ...
  - `h7` = 14 像素
- **用途**: 制作路缘石（马路牙子）、台阶、花坛边缘等需要精细高度差的结构。

### 5.3 特殊功能类说明

- **`DirectionalRoadBlock`**:
  - 核心逻辑: 在 `getStateForPlacement` 中获取玩家视角的对面方向 (`getOpposite`)，实现“面向玩家”的放置效果。
  - 状态属性: `FACING` (DirectionProperty)。
- **`HeightRoadBlock`**:
  - 核心逻辑: 重写 `getShape`, `getCollisionShape`, `getOcclusionShape`，返回基于 `height` 参数构建的 `VoxelShape`。
  - 构造参数: `float height` (像素单位)。
- **`DirectionalHeightRoadBlock`**:
  - 核心逻辑: 同时继承了上述两者的特性，既有自定义高度，又能旋转方向。常用于带有标线的路缘石。
