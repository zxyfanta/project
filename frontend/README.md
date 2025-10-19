# 基于vite的vue项目

# node 22.04 + 版本

``` npm create vite@latest```
上述指令用于创建项目，如果是第一次执行，则需要安装vite（就是在提示中输入y）
1. 项目名称，frontend
2. 模板  vue
3. 语言 js

注意点：
在执行上述命令的时候，需要将当前命令行的位置切换到project根目录。

安装依赖
安装当前package.json 中的全部依赖
1. npm i 

安装我们需要的特定依赖

2. npm i axios
3. npm i element-plus

## axios
在项目中需要单独进行配置，涉及前端守卫，后端守卫

## element-plus
涉及 全引用,main.js

import ElementPlus from 'element-plus'

import 'element-plus/dist/index.css'

// const app=createApp(App)

// app.use(ElementPlus)

// app.mount("#app")