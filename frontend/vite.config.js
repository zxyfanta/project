import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import path from 'path'

// https://vite.dev/config/
export default defineConfig({
  plugins: [vue()],
  resolve:{
    alias:{
      '@': path.resolve(__dirname,'./src'),
    }
  },
  server:{
    proxy:{
      '/api':{
        target:"http://localhost:8080",
        changeOrigin: true, //开启这个选项，意味着，vite会自动的修改Origin字段。
      }
    }
  }

})
