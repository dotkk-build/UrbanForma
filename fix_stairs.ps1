# 脚本：修复所有楼梯方块的旋转问题

# 获取所有楼梯文件
$stairFiles = Get-ChildItem -Path "src/main/resources/assets/urbanforma/blockstates" -Filter "*_stbb.json"

foreach ($file in $stairFiles) {
    Write-Host "修复楼梯文件: $($file.Name)"
    
    # 读取文件内容
    $content = Get-Content -Path $file.FullName -Raw
    
    # 交换内外角的旋转配置
    $content = $content -replace '"shape=outer_right"', '"shape=TEMP_outer"'
    $content = $content -replace '"shape=outer_left"', '"shape=outer_right"'
    $content = $content -replace '"shape=TEMP_outer"', '"shape=outer_left"'
    
    $content = $content -replace '"shape=inner_right"', '"shape=TEMP_inner"'
    $content = $content -replace '"shape=inner_left"', '"shape=inner_right"'
    $content = $content -replace '"shape=TEMP_inner"', '"shape=inner_left"'
    
    # 写回文件
    Set-Content -Path $file.FullName -Value $content -Encoding UTF8
}

Write-Host "所有楼梯文件修复完成！"