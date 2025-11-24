# 脚本：修复所有楼梯方块的旋转问题

import os
import json

def fix_stair_rotation(file_path):
    """修复楼梯方块的旋转配置"""
    with open(file_path, 'r', encoding='utf-8') as f:
        data = json.load(f)
    
    variants = data.get("variants", {})
    
    # 修复下半部分内外角的旋转
    for key in list(variants.keys()):
        if "outer_right" in key:
            new_key = key.replace("outer_right", "temp_outer")
            variants[new_key] = variants[key]
            del variants[key]
        elif "outer_left" in key:
            new_key = key.replace("outer_left", "outer_right")
            variants[new_key] = variants[key]
            del variants[key]
        elif "temp_outer" in key:
            new_key = key.replace("temp_outer", "outer_left")
            variants[new_key] = variants[key]
            del variants[key]
        elif "inner_right" in key:
            new_key = key.replace("inner_right", "temp_inner")
            variants[new_key] = variants[key]
            del variants[key]
        elif "inner_left" in key:
            new_key = key.replace("inner_left", "inner_right")
            variants[new_key] = variants[key]
            del variants[key]
        elif "temp_inner" in key:
            new_key = key.replace("temp_inner", "inner_left")
            variants[new_key] = variants[key]
            del variants[key]
    
    # 保存修改后的文件
    with open(file_path, 'w', encoding='utf-8') as f:
        json.dump(data, f, indent=2, ensure_ascii=False)
    
    print(f"已修复: {file_path}")

# 楼梯文件目录
blockstates_dir = "d:/UrbanForma/Forge/1.18.2/src/main/resources/assets/urbanforma/blockstates"

# 遍历所有楼梯文件
for filename in os.listdir(blockstates_dir):
    if filename.endswith("_stbb.json"):
        file_path = os.path.join(blockstates_dir, filename)
        fix_stair_rotation(file_path)

print("所有楼梯文件修复完成！")