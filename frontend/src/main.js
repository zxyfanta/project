import { createApp } from 'vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import './style.css'
import App from './App.vue'

// const app=createApp(App)
// app.use(ElementPlus)
// app.mount("#app")
// 该语句，和上述三条语句等价
createApp(App).use(ElementPlus).mount('#app')
