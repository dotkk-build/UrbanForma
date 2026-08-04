# UrbanForma

UrbanForma 是一个面向城市建筑的 Minecraft 内容模组，提供建筑材料、玻璃、
照明、道路和其他城市装饰方块。本项目将原始 UrbanForma 1.20.1 内容迁移到
Minecraft 1.21.1 的 NeoForge 环境。

## 当前公开版本

- Minecraft：`1.21.1`
- NeoForge：`21.1.234` 或兼容的更高版本
- Java：`21`
- Mod ID：`urbanforma`
- Mod 版本：`1.1016+mc1.21.1`
- 许可证：MIT

仓库的 `main` 分支是当前公开的 Minecraft 1.21.1 NeoForge 移植版本。
名为 `1.20.1-Forge` 的分支是旧版 Forge 内容，不能作为当前 `main` 的兼容性声明。

## 依赖

模组 metadata 声明 `urbanforma_neo` 为必需依赖。请确保整合包中的
Urbanforma:neo 与 Minecraft、NeoForge 版本匹配。

## 安装

1. 安装 Minecraft `1.21.1`。
2. 安装 NeoForge `21.1.234` 或兼容的更高版本。
3. 使用 Java `21` 启动游戏或服务器。
4. 将 UrbanForma JAR 和匹配的 Urbanforma:neo 依赖放入实例的 `mods` 文件夹。
5. 启动游戏或服务器，并在日志中确认相关模组均已加载。

客户端和服务器应使用相同的 Minecraft、NeoForge、Java 与模组版本。
本仓库不包含运行时、启动器或游戏目录。

## 从源码构建

安装 JDK `21` 后，在项目根目录运行 Gradle Wrapper：

```powershell
gradlew.bat build
```

在 POSIX shell 中运行：

```text
./gradlew build
```

构建产物会生成在 `build/libs/`。仓库包含 Gradle Wrapper 和公开项目 metadata，
不依赖机器专属的 Java 路径配置。

## 项目状态

本仓库提供 Minecraft 1.21.1 NeoForge 移植的公开源码。它按现状提供，
不代表原始内容的所有功能都已完成等价迁移。客户端画面、服务器行为和多人联机
兼容性应在目标环境中分别验证。

## 许可证

本项目使用 MIT License，详见 [LICENSE](LICENSE)。
