<template>
  <!-- 旋转星空背景 -->
  <TresGroup ref="starsGroupRef">
    <TresPoints>
      <TresBufferGeometry>
        <TresBufferAttribute
          :args="[starPositions, 3]"
          attach="attributes-position"
        />
        <TresBufferAttribute
          :args="[starSizes, 1]"
          attach="attributes-size"
        />
        <TresBufferAttribute
          :args="[starColors, 3]"
          attach="attributes-color"
        />
      </TresBufferGeometry>
      <TresPointsMaterial
        :size="2"
        size-attenuation
        :transparent="true"
        :opacity="0.9"
        vertex-colors
      />
    </TresPoints>
  </TresGroup>

  <!-- 登录表单HTML覆盖层 -->
  <Html
    center
    transform
    :distance-factor="4"
    :position="[0, 0, 0.65]"
    :scale="[0.75, 0.75, 0.75]"
  >
    <LoginForm />
  </Html>
</template>

<script setup>
import { ref } from 'vue'
import { useLoop } from '@tresjs/core'
import { Html } from '@tresjs/cientos'
import LoginForm from './LoginForm.vue'

const starsGroupRef = ref()
const { onBeforeRender } = useLoop()

// 创建星空数据
const createStarsData = (count = 10000) => {
  const positions = new Float32Array(count * 3)
  const sizes = new Float32Array(count)
  const colors = new Float32Array(count * 3)

  for (let i = 0; i < count; i++) {
    const i3 = i * 3

    // 随机位置 - 创建球形分布
    const radius = Math.random() * 1000 + 500
    const theta = Math.random() * Math.PI * 2
    const phi = Math.acos(Math.random() * 2 - 1)

    positions[i3] = radius * Math.sin(phi) * Math.cos(theta)
    positions[i3 + 1] = radius * Math.sin(phi) * Math.sin(theta)
    positions[i3 + 2] = radius * Math.cos(phi)

    // 随机大小
    sizes[i] = Math.random() * 3 + 0.5

    // 随机颜色 - 蓝白色调
    const colorVariation = Math.random()
    if (colorVariation > 0.8) {
      // 蓝色星星
      colors[i3] = 0.4 + Math.random() * 0.3     // R
      colors[i3 + 1] = 0.6 + Math.random() * 0.4 // G
      colors[i3 + 2] = 1.0                       // B
    } else {
      // 白色星星
      const brightness = 0.7 + Math.random() * 0.3
      colors[i3] = brightness     // R
      colors[i3 + 1] = brightness // G
      colors[i3 + 2] = brightness // B
    }
  }

  return { positions, sizes, colors }
}

const { positions: starPositions, sizes: starSizes, colors: starColors } = createStarsData(12000)

// 动画循环
onBeforeRender(({ delta }) => {
  if (starsGroupRef.value) {
    // 缓慢旋转星空
    starsGroupRef.value.rotation.y += delta * 0.02
    starsGroupRef.value.rotation.x += delta * 0.01

    // 添加轻微的脉动效果
    const time = Date.now() * 0.001
    starsGroupRef.value.rotation.z = Math.sin(time * 0.1) * 0.05
  }
})
</script>

<style>

</style>