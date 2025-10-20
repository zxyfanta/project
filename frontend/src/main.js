import { createApp } from 'vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import './style.css'
import './index.css'
import Tres from '@tresjs/core'
import router from '@/router/index.js'
import App from './App.vue'

// const app=createApp(App)
// app.use(ElementPlus)
// app.mount("#app")
// 该语句，和上述三条语句等价
createApp(App).use(Tres).use(ElementPlus).use(router).mount('#app')
