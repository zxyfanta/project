import { createApp } from 'vue'
import './style.css'
import './index.css'
import Tres from '@tresjs/core'
import router from '@/router/index.js'
import App from './App.vue'

// 创建Vue应用实例并挂载
createApp(App).use(Tres).use(router).mount('#app')
