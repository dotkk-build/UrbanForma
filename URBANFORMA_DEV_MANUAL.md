# UrbanForma 开发手册

本手册整合了 UrbanForma 模组的开发指南、项目结构说明及方块参考，旨在为开发者提供详尽的一站式参考资料。

---

## 版本历史

### v1.07a - 2025-12-02
**边墙和细边墙物品栏位置调整**
- 调整边墙和细边墙在创造模式物品栏中的位置，使它们与对应颜色的方块系列放在一起
- 亮灰1-3的边墙和细边墙现在会紧跟在亮灰1-3的方块后面
- 中灰1-3的边墙和细边墙现在会紧跟在中灰1-3的方块后面
- 暗灰1-4的边墙和细边墙现在会紧跟在暗灰1-4的方块后面
- 黑灰和黑色的边墙和细边墙现在会紧跟在黑灰和黑色的方块后面
- 更新版本到 1.07b

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
d:\UrbanForma\
└── Forge\
    └── 1.20.1\                       // [新结构] Minecraft 1.20.1 版本目录
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
        ├── CHANGELOG.md                    // 版本更新记录
        ├── URBANFORMA_DEV_MANUAL.md        // 开发手册 (本文件)
        ├── 工作流程检查表.md                // 工作流程检查表
        ├── build.gradle                    // Gradle 构建脚本，定义依赖和构建任务
        ├── gradle.properties               // 模组版本配置
        └── README.md                       // 项目说明文档
```

### 2.2 资源文件详解

添加一个新方块时，必须完整创建以下 5 类资源文件，缺一不可：

| 资源类型              | 路径示例 (`assets/urbanforma/...`) | 详细说明                                                                                                                                                             |
| :-------------------- | :----------------------------------- | :------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Blockstate**  | `blockstates/my_block.json`        | **状态映射**。定义方块的 `variants`（变种）。对于普通方块，通常映射到单一模型；对于方向性方块，需定义 `facing=north` 等状态对应的旋转角度 (`y` 轴旋转)。 |
| **Block Model** | `models/block/my_block.json`       | **几何模型**。定义方块的形状（`parent`）和纹理（`textures`）。普通方块通常继承 `block/cube_all`；自定义形状方块需指定具体的父模型或自定义元素。          |
| **Item Model**  | `models/item/my_block.json`        | **物品展示**。定义方块在玩家手中、物品栏或掉落时的外观。通常直接继承对应的 Block Model (`parent: urbanforma:block/my_block`)。                               |
| **Texture**     | `textures/block/my_block.png`      | **纹理贴图**。实际的图片文件。建议使用 16x16 像素的标准 Minecraft 风格贴图。                                                                                   |
| **Lang (CN)**   | `lang/zh_cn.json`                  | **本地化名称**。格式为 `"block.urbanforma.registry_name": "中文名称"`。请务必保持键名与注册名一致。                                                          |

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
  cd d:\UrbanForma\Forge\1.20.1; gradle build
  ```

  此命令会编译代码并生成 `.jar` 文件，通常位于 `build/libs` 目录下。
- **启动测试客户端**:

  ```powershell
  cd d:\UrbanForma\Forge\1.20.1; .\gradlew runClient
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
- **边墙**: `[前缀]_border` (Border Wall) - 半宽方块(8像素)，支持四方向旋转
- **细边墙**: `[前缀]_thin_border` (Thin Border Wall) - 细边墙方块(4像素)，支持四方向旋转
- **玻璃**: `[前缀]_glass` (Glass) - 透明玻璃方块，继承自GlassBlock
- **玻璃片**: `[前缀]_glass_pane` (Glass Pane) - 基于细边墙的玻璃片(4像素)，继承自GlassBlock，支持四方向旋转

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
  - 核心逻辑: 在 `getStateForPlacement` 中获取玩家视角的对面方向 (`getOpposite`)，实现"面向玩家"的放置效果。
  - 状态属性: `FACING` (DirectionProperty)。
- **`HeightRoadBlock`**:
  - 核心逻辑: 重写 `getShape`, `getCollisionShape`, `getOcclusionShape`，返回基于 `height` 参数构建的 `VoxelShape`。
  - 构造参数: `float height` (像素单位)。
- **`DirectionalHeightRoadBlock`**:
  - 核心逻辑: 同时继承了上述两者的特性，既有自定义高度，又能旋转方向。常用于带有标线的路缘石。
- **`BorderWallBlock`**:
  - 核心逻辑: 半宽方块(8像素)，支持四方向旋转。默认放置方向比玩家面向的方向顺时针旋转90度。
  - 状态属性: `FACING` (DirectionProperty)。
  - 形状定义: 根据方向返回不同的VoxelShape，确保视觉表现和碰撞体积一致。
- **`ThinBorderWallBlock`**:
  - 核心逻辑: 细边墙方块(4像素)，支持四方向旋转。默认放置方向比玩家面向的方向顺时针旋转90度。
  - 状态属性: `FACING` (DirectionProperty)。
  - 形状定义: 根据方向返回不同的VoxelShape，确保视觉表现和碰撞体积一致。

---

## 6. 版本更新记录 (Version Updates)

### 6.1 版本命名规范

- **主版本号** (v1.x.x): 重大功能更新或架构变更
- **次版本号** (vx.1.x): 新功能添加
- **修订版本号** (vx.x.1): 错误修复和优化

### 6.2 更新记录格式

每个版本更新应包含：

- 版本号和发布日期
- 新增内容 (🆕)
- 改进和优化 (🔧)
- 错误修复 (🐛)
- 已知问题 (⚠️)

---

## 7. 版本历史记录 (Version History)

### v1.07 - 2025-12-01

**白色玻璃系统添加和调整**

#### 🆕 新增内容

- **白色玻璃方块**: 添加了白色玻璃方块 (WHITE_GLASS)，透明材质，适合作为建筑窗户玻璃
- **白色玻璃片方块**: 添加了白色玻璃片方块 (WHITE_GLASS_PANE)，基于白色细边墙的4像素宽玻璃片，支持四方向旋转
- **玻璃方块类**: 实现了WhiteGlassBlock类，继承自GlassBlock
- **玻璃片方块类**: 实现了WhiteGlassPaneBlock类，继承自GlassBlock并支持方向旋转
- **资源文件**: 为两种新方块创建了完整的方块状态、模型、物品模型和语言文件

#### 🎯 功能特性

- **透明渲染**: 实现了白色玻璃和白色玻璃片的透明渲染层设置
- **UV贴图映射**: 优化了白色玻璃片的UV贴图映射，确保只显示4像素宽区域的贴图
- **智能放置方向**: 默认放置方向比玩家面向的方向逆时针旋转180度

#### 📚 技术文档更新

- 更新了URBANFORMA_DEV_MANUAL.md，添加了白色玻璃和白色玻璃片的特殊功能类说明
- 在命名规范中增加了玻璃和玻璃片的说明

### v1.06 - 2025-11-30

**边墙系统完善和技术规范统一**

#### 🆕 新增内容

- **边墙方块系统**: 添加了白色边墙方块 (WHITE_BORDER_WALL)
- **细边墙方块**: 添加了白色细边墙方块 (WHITE_THIN_BORDER_WALL)
- **四方向旋转**: 两种边墙方块均支持完整的四方向旋转
- **自定义碰撞体积**: 实现了与视觉效果一致的精确碰撞体积
- **自定义方块类**:
  - BorderWallBlock: 半宽方块(8像素)
  - ThinBorderWallBlock: 细边墙方块(4像素)

#### 🎯 功能特性

- **智能放置方向**: 默认放置方向比玩家面向的方向顺时针旋转90度
- **精确碰撞体积**: 8像素和4像素宽度与视觉效果完全匹配
- **旋转支持**: 北、南、东、西四个方向的完整支持
- **纹理一致性**: 使用现有的 b_white.png 贴图，保持视觉风格统一

#### 🔧 技术改进

- 完整的方块状态和模型定义
- 简化的注册方法 (registerBorderWallBlock, registerThinBorderWallBlock)
- 标准化的创造模式物品栏分类
- 完整的中英双语本地化支持

#### 📚 文档更新

- 更新开发手册中的方块参考和命名规则
- 完善边墙方块的技术文档和使用说明
- 添加自定义方块类的详细说明

---

### v1.05d - 2025-11-23

**文件结构重组和韩语翻译修复**

#### 🆕 新增内容

- **文件结构重组**: 重新组织项目文件结构，支持多版本开发
- **新目录结构**: 创建了 Forge/1.20.1 子目录结构
- **文档更新**: 更新了所有文档以反映新的文件结构

#### 🔧 技术改进

- 修复了韩语翻译缺失问题
- 更新了所有构建命令路径
- 优化了项目目录结构，为未来版本支持做准备

---

### v1.05c - 2025-11-05

**韩语本地化和版本更新**

#### 🌍 本地化

- **韩语语言支持**: 添加了完整的韩语本地化文件 (ko_kr.json)
- **专业翻译**: 使用了地道的韩语术语和颜色命名
- **完整覆盖**: 翻译了全部72个彩色建筑块系列和道路系统组件

#### 🔧 技术改进

- 更新模组版本为 1.05c
- 增强了多语言支持系统
- 改进了本地化一致性

---

### v1.05b - 2025-11-05

**日语本地化和版本更新**

#### 🌍 本地化

- **日语语言支持**: 添加了完整的日语本地化文件 (ja_jp.json)
- **专业翻译**: 使用了地道的日语术语和传统颜色名称
- **完整覆盖**: 翻译了全部72个彩色建筑块系列和道路系统组件

#### 🔧 技术改进

- 更新模组版本为 1.05b
- 增强了语言文件结构一致性
- 改进了国际化支持

---

### v1.03 - 2025-10-31

**白色中线高路缘石增强**

#### 🆕 新增内容

- **白色中线高路缘石**: 添加了7个带白色中线的方向性高路缘石方块 (r_wl_h1 to r_wl_h7)
- **方向性功能**: 实现了 DirectionalHeightRoadBlock 以实现正确的方向放置
- **纹理优化**: 更新顶面纹理使用 r_gray_l1.png 以保持一致外观

#### 🔧 技术改进

- 修复了方向面对的方块状态配置
- 增强了纹理映射与适当的变量引用
- 改进了 ModBlocks.java 中的方块注册一致性

---

### v1.02 - 2025-10-31

**道路系统增强**

#### 🆕 新增内容

- **道路方块系统**: 添加了35个带白色标记的道路方块 (r_wl1 to r_wl35)
- **方向性道路方块**: 实现了 DirectionalRoadBlock 用于方向性放置
- **道路标记类型**:
  - 中心线、45度线、斑马线
  - 角落线、T型线、十字线
  - 小型、中型和大型曲线及其反向变体
  - 45度曲线及其反向变体

#### 🔧 技术改进

- 增强了 ModBlocks.java 的综合道路方块注册
- 更新了创造模式物品栏的道路方块分类
- 为所有道路方块提供了完整的中文本地化
- 标准化了纹理映射系统

---

### v1.0.0 - 2025-10-29

**初始发布**

#### 🆕 新增内容

- **基础模组框架**: 完整的 Forge 1.20.1 模组结构
- **建筑方块**:

  - 都市方块 (urban_block)
  - 现代方块 (modern_block)
- **UI支持**:

  - 自定义创造模式物品栏
  - 完整的中文和英文语言文件
- **技术特性**:

  - 完整的方块状态和模型定义
  - 标准 META-INF 配置
  - Gradle 构建系统配置

#### 🔧 技术改进

- 基于 Forge 47.2.0 构建
- 支持 Minecraft 1.20.1
- 使用 Java 17 编译
- 完整的构建和开发环境配置
