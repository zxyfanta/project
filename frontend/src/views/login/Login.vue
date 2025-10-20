<script setup>
import LoginScene from '@/views/login/component/LoginScene.vue'
import { OrbitControls } from '@tresjs/cientos'

</script>

<template>
  <div class="w-full h-screen bg-gradient-to-br from-slate-900 via-purple-900 to-slate-900 overflow-hidden">
    <TresCanvas window-size class="absolute inset-0">
      <!-- 相机设置 -->
      <TresPerspectiveCamera :position="[0, 0, 5]" />

      <!-- 轨道控制器 - 限制用户交互 -->
      <OrbitControls
        :enable-zoom="false"
        :enable-pan="false"
        :enable-rotate="true"
        :auto-rotate="false"
        :max-polar-angle="Math.PI / 2"
        :min-polar-angle="Math.PI / 2"
      />

      <!-- 环境光 -->
      <TresAmbientLight :intensity="0.3" />

      <!-- 点光源 -->
      <TresPointLight :position="[10, 10, 10]" :intensity="0.5" />

      <!-- 登录场景组件 -->
      <LoginScene />
    </TresCanvas>

    <!-- 渐变遮罩层 -->
    <div class="absolute inset-0 bg-gradient-to-t from-black/20 via-transparent to-black/10 pointer-events-none"></div>
  </div>
</template>

<style scoped>
/* 确保3D画布占满整个屏幕 */
:deep(.tres-canvas) {
  position: absolute !important;
  top: 0 !important;
  left: 0 !important;
  width: 100% !important;
  height: 100% !important;
}

/* 隐藏滚动条 */
body {
  overflow: hidden;
}
</style>