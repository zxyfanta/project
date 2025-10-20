<template>
  <div class="min-h-screen flex items-center justify-center bg-transparent relative overflow-hidden">
    <!-- 背景动画网格 -->
    <div class="absolute inset-0 opacity-20">
      <div class="cyber-grid"></div>
    </div>

    <!-- 背景粒子效果 -->
    <div class="absolute inset-0">
      <div class="particle" v-for="i in 50" :key="i" :style="getParticleStyle(i)"></div>
    </div>

    <!-- 扫描线效果 -->
    <div class="scan-line"></div>

    <!-- 主登录容器 -->
    <div class="cyber-container relative z-10">
      <!-- 外边框装饰 -->
      <div class="cyber-border-decoration">
        <div class="corner-decoration top-left"></div>
        <div class="corner-decoration top-right"></div>
        <div class="corner-decoration bottom-left"></div>
        <div class="corner-decoration bottom-right"></div>
      </div>

      <!-- 标题区域 -->
      <div class="text-center mb-8 relative">
        <div class="cyber-title-container">
          <h1 class="cyber-title">
            <span class="glitch-text" data-text="QUANTUM ACCESS">QUANTUM ACCESS</span>
          </h1>
          <div class="cyber-subtitle">
            <span class="text-cyan-400 font-mono text-sm tracking-widest">SYSTEM V2.0</span>
          </div>
        </div>

        <!-- 标题装饰线 -->
        <div class="cyber-title-lines">
          <div class="cyber-line left"></div>
          <div class="cyber-line right"></div>
        </div>
      </div>

      <!-- 登录表单 -->
      <form @submit.prevent="handleLogin" class="space-y-6">
        <!-- 用户名输入区域 -->
        <div class="cyber-input-group">
          <label class="cyber-label">
            <span class="cyber-label-text">USER_ID</span>
            <span class="cyber-label-indicator"></span>
          </label>
          <div class="cyber-input-container" :class="{ 'error': errors.userName, 'focused': focusedField === 'userName' }">
            <div class="cyber-input-decoration">
              <div class="input-corner tl"></div>
              <div class="input-corner tr"></div>
              <div class="input-corner bl"></div>
              <div class="input-corner br"></div>
            </div>
            <div class="cyber-input-icon">
              <svg class="w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M16 7a4 4 0 11-8 0 4 4 0 018 0zM12 14a7 7 0 00-7 7h14a7 7 0 00-7-7z" />
              </svg>
            </div>
            <input
              v-model="loginForm.userName"
              type="text"
              placeholder="ENTER_USERNAME"
              class="cyber-input"
              @focus="focusedField = 'userName'"
              @blur="focusedField = ''"
            />
            <div class="cyber-input-glow"></div>
          </div>
          <div v-if="errors.userName" class="cyber-error">
            <span class="error-icon">⚠</span>
            <span class="error-text">{{ errors.userName }}</span>
          </div>
        </div>

        <!-- 密码输入区域 -->
        <div class="cyber-input-group">
          <label class="cyber-label">
            <span class="cyber-label-text">PASSWORD</span>
            <span class="cyber-label-indicator"></span>
          </label>
          <div class="cyber-input-container" :class="{ 'error': errors.password, 'focused': focusedField === 'password' }">
            <div class="cyber-input-decoration">
              <div class="input-corner tl"></div>
              <div class="input-corner tr"></div>
              <div class="input-corner bl"></div>
              <div class="input-corner br"></div>
            </div>
            <div class="cyber-input-icon">
              <svg class="w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 15v2m-6 4h12a2 2 0 002-2v-6a2 2 0 00-2-2H6a2 2 0 00-2 2v6a2 2 0 002 2zm10-10V7a4 4 0 00-8 0v4h8z" />
              </svg>
            </div>
            <input
              v-model="loginForm.password"
              :type="showPassword ? 'text' : 'password'"
              placeholder="ENTER_PASSWORD"
              class="cyber-input"
              @focus="focusedField = 'password'"
              @blur="focusedField = ''"
            />
            <button
              type="button"
              @click="showPassword = !showPassword"
              class="cyber-toggle-btn"
            >
              <svg v-if="showPassword" class="w-4 h-4" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M13.875 18.825A10.05 10.05 0 0112 19c-4.478 0-8.268-2.943-9.543-7a9.97 9.97 0 011.563-3.029m5.858.908a3 3 0 114.243 4.243M9.878 9.878l4.242 4.242M9.878 9.878L3 3m6.878 6.878L21 21" />
              </svg>
              <svg v-else class="w-4 h-4" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15 12a3 3 0 11-6 0 3 3 0 016 0z" />
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M2.458 12C3.732 7.943 7.523 5 12 5c4.478 0 8.268 2.943 9.542 7-1.274 4.057-5.064 7-9.542 7-4.477 0-8.268-2.943-9.542-7z" />
              </svg>
            </button>
            <div class="cyber-input-glow"></div>
          </div>
          <div v-if="errors.password" class="cyber-error">
            <span class="error-icon">⚠</span>
            <span class="error-text">{{ errors.password }}</span>
          </div>
        </div>

        <!-- 自动登录选项 -->
        <div class="cyber-checkbox-group">
          <label class="cyber-checkbox-container">
            <input
              v-model="autoLogin"
              type="checkbox"
              class="sr-only"
            />
            <div class="cyber-checkbox" :class="{ 'checked': autoLogin }">
              <div class="checkbox-inner">
                <div class="checkbox-glow"></div>
                <svg v-if="autoLogin" class="checkbox-icon" fill="currentColor" viewBox="0 0 20 20">
                  <path fill-rule="evenodd" d="M16.707 5.293a1 1 0 010 1.414l-8 8a1 1 0 01-1.414 0l-4-4a1 1 0 011.414-1.414L8 12.586l7.293-7.293a1 1 0 011.414 0z" clip-rule="evenodd" />
                </svg>
              </div>
            </div>
            <span class="cyber-checkbox-label">AUTO_LOGIN_ENABLED</span>
          </label>
        </div>

        <!-- 登录按钮 -->
        <div class="cyber-button-container">
          <button
            type="submit"
            :disabled="loading"
            class="cyber-button"
            :class="{ 'loading': loading }"
          >
            <div class="button-bg"></div>
            <div class="button-border"></div>
            <div class="button-content">
              <div v-if="loading" class="loading-spinner">
                <div class="spinner-ring"></div>
                <div class="spinner-ring"></div>
                <div class="spinner-ring"></div>
              </div>
              <span class="button-text">{{ loading ? 'ACCESSING...' : 'INITIALIZE_LOGIN' }}</span>
            </div>
            <div class="button-glow"></div>
          </button>
        </div>
      </form>

      <!-- 底部状态指示器 -->
      <div class="cyber-status-bar">
        <div class="status-indicator">
          <div class="status-dot active"></div>
          <span class="status-text">SYSTEM_ONLINE</span>
        </div>
        <div class="status-indicator">
          <div class="status-dot"></div>
          <span class="status-text">SECURE_CONNECTION</span>
        </div>
      </div>
    </div>
  </div>
</template>
<script setup>
import { ref, reactive, onMounted } from 'vue'

const autoLogin = ref(true)
const loading = ref(false)
const showPassword = ref(false)
const focusedField = ref('')

const loginForm = reactive({
  userName: 'admin',
  password: '123456',
})

const errors = reactive({
  userName: '',
  password: ''
})

// 生成粒子样式
const getParticleStyle = () => {
  const size = Math.random() * 3 + 1
  const x = Math.random() * 100
  const y = Math.random() * 100
  const duration = Math.random() * 20 + 10
  const delay = Math.random() * 5

  return {
    width: `${size}px`,
    height: `${size}px`,
    left: `${x}%`,
    top: `${y}%`,
    animationDuration: `${duration}s`,
    animationDelay: `${delay}s`
  }
}

// 表单验证函数
const validateForm = () => {
  let isValid = true

  // 清除之前的错误信息
  errors.userName = ''
  errors.password = ''

  // 验证用户名
  if (!loginForm.userName.trim()) {
    errors.userName = 'USER_ID_REQUIRED'
    isValid = false
  } else if (loginForm.userName.length < 2 || loginForm.userName.length > 20) {
    errors.userName = 'INVALID_USER_ID_LENGTH'
    isValid = false
  }

  // 验证密码
  if (!loginForm.password.trim()) {
    errors.password = 'PASSWORD_REQUIRED'
    isValid = false
  } else if (loginForm.password.length < 6 || loginForm.password.length > 20) {
    errors.password = 'INVALID_PASSWORD_LENGTH'
    isValid = false
  }

  return isValid
}

// 科技感消息提示
const showCyberMessage = (message, type = 'success') => {
  const messageEl = document.createElement('div')
  messageEl.className = `fixed top-6 right-6 z-50 px-6 py-3 font-mono text-sm transition-all duration-500 transform translate-x-full ${
    type === 'success'
      ? 'bg-gradient-to-r from-green-500/20 to-cyan-500/20 border border-green-400/50 text-green-400'
      : 'bg-gradient-to-r from-red-500/20 to-pink-500/20 border border-red-400/50 text-red-400'
  } backdrop-blur-md rounded-lg shadow-2xl`

  messageEl.innerHTML = `
    <div class="flex items-center space-x-2">
      <div class="w-2 h-2 rounded-full ${type === 'success' ? 'bg-green-400' : 'bg-red-400'} animate-pulse"></div>
      <span>${message}</span>
    </div>
  `

  document.body.appendChild(messageEl)

  // 显示动画
  setTimeout(() => {
    messageEl.classList.remove('translate-x-full')
  }, 100)

  // 3秒后移除
  setTimeout(() => {
    messageEl.classList.add('translate-x-full')
    setTimeout(() => {
      if (document.body.contains(messageEl)) {
        document.body.removeChild(messageEl)
      }
    }, 500)
  }, 3000)
}

const handleLogin = async () => {
  if (!validateForm()) {
    showCyberMessage('ACCESS_DENIED: INVALID_CREDENTIALS', 'error')
    return
  }

  loading.value = true

  try {
    // 模拟登录请求
    await new Promise(resolve => setTimeout(resolve, 2500))

    loading.value = false
    showCyberMessage('ACCESS_GRANTED: WELCOME_TO_SYSTEM', 'success')
    console.log('登录信息:', {
      ...loginForm,
      autoLogin: autoLogin.value
    })

    // 这里可以添加路由跳转逻辑
    // router.push('/')

  } catch (error) {
    loading.value = false
    showCyberMessage('SYSTEM_ERROR: CONNECTION_FAILED', 'error')
    console.error('登录错误:', error)
  }
}

// 组件挂载后的初始化
onMounted(() => {
  // 添加键盘事件监听
  const handleKeyPress = (e) => {
    if (e.key === 'Enter' && !loading.value) {
      handleLogin()
    }
  }

  document.addEventListener('keypress', handleKeyPress)

  // 组件卸载时清理事件监听
  return () => {
    document.removeEventListener('keypress', handleKeyPress)
  }
})
</script>
<style scoped>
/* 导入等宽字体 */
@import url('https://fonts.googleapis.com/css2?family=JetBrains+Mono:wght@300;400;500;600;700&display=swap');

/* 基础变量 */
:root {
  --cyber-primary: #00ffff;
  --cyber-secondary: #ff00ff;
  --cyber-accent: #00ff41;
  --cyber-warning: #ffaa00;
  --cyber-error: #ff0040;
  --cyber-bg: rgba(0, 0, 0, 0.8);
  --cyber-border: rgba(0, 255, 255, 0.3);
  --cyber-glow: 0 0 20px rgba(0, 255, 255, 0.5);
}

/* 背景网格动画 */
.cyber-grid {
  width: 100%;
  height: 100%;
  background-image:
    linear-gradient(rgba(0, 255, 255, 0.1) 1px, transparent 1px),
    linear-gradient(90deg, rgba(0, 255, 255, 0.1) 1px, transparent 1px);
  background-size: 50px 50px;
  animation: grid-move 20s linear infinite;
}

@keyframes grid-move {
  0% { transform: translate(0, 0); }
  100% { transform: translate(50px, 50px); }
}

/* 粒子效果 */
.particle {
  position: absolute;
  background: radial-gradient(circle, var(--cyber-primary) 0%, transparent 70%);
  border-radius: 50%;
  animation: particle-float infinite linear;
  opacity: 0.6;
}

@keyframes particle-float {
  0% {
    transform: translateY(100vh) rotate(0deg);
    opacity: 0;
  }
  10% {
    opacity: 0.6;
  }
  90% {
    opacity: 0.6;
  }
  100% {
    transform: translateY(-100px) rotate(360deg);
    opacity: 0;
  }
}

/* 扫描线效果 */
.scan-line {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 2px;
  background: linear-gradient(90deg, transparent, var(--cyber-primary), transparent);
  animation: scan 3s ease-in-out infinite;
  opacity: 0.8;
}

@keyframes scan {
  0%, 100% {
    transform: translateY(0);
    opacity: 0;
  }
  50% {
    transform: translateY(100vh);
    opacity: 0.8;
  }
}

/* 主容器 */
.cyber-container {
  position: relative;
  width: 100%;
  max-width: 420px;
  padding: 2rem;
  background: linear-gradient(135deg,
    rgba(0, 0, 0, 0.9) 0%,
    rgba(0, 20, 40, 0.8) 50%,
    rgba(0, 0, 0, 0.9) 100%);
  border: 1px solid var(--cyber-border);
  border-radius: 0;
  backdrop-filter: blur(20px);
  box-shadow:
    0 0 50px rgba(0, 255, 255, 0.2),
    inset 0 0 50px rgba(0, 255, 255, 0.05);
  font-family: 'JetBrains Mono', monospace;
  transform: translateZ(0);
  animation: container-glow 4s ease-in-out infinite alternate;
}

@keyframes container-glow {
  0% {
    box-shadow:
      0 0 50px rgba(0, 255, 255, 0.2),
      inset 0 0 50px rgba(0, 255, 255, 0.05);
  }
  100% {
    box-shadow:
      0 0 80px rgba(0, 255, 255, 0.4),
      inset 0 0 50px rgba(0, 255, 255, 0.1);
  }
}

/* 边框装饰 */
.cyber-border-decoration {
  position: absolute;
  inset: -1px;
  pointer-events: none;
}

.corner-decoration {
  position: absolute;
  width: 20px;
  height: 20px;
  border: 2px solid var(--cyber-primary);
}

.corner-decoration.top-left {
  top: 0;
  left: 0;
  border-right: none;
  border-bottom: none;
}

.corner-decoration.top-right {
  top: 0;
  right: 0;
  border-left: none;
  border-bottom: none;
}

.corner-decoration.bottom-left {
  bottom: 0;
  left: 0;
  border-right: none;
  border-top: none;
}

.corner-decoration.bottom-right {
  bottom: 0;
  right: 0;
  border-left: none;
  border-top: none;
}

/* 标题样式 */
.cyber-title-container {
  position: relative;
  margin-bottom: 1rem;
}

.cyber-title {
  font-size: 1.8rem;
  font-weight: 700;
  text-align: center;
  margin-bottom: 0.5rem;
}

.glitch-text {
  position: relative;
  color: var(--cyber-primary);
  text-shadow:
    0 0 10px var(--cyber-primary),
    0 0 20px var(--cyber-primary),
    0 0 40px var(--cyber-primary);
  animation: glitch 2s infinite;
}

.glitch-text::before,
.glitch-text::after {
  content: attr(data-text);
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}

.glitch-text::before {
  animation: glitch-1 0.5s infinite;
  color: var(--cyber-secondary);
  z-index: -1;
}

.glitch-text::after {
  animation: glitch-2 0.5s infinite;
  color: var(--cyber-accent);
  z-index: -2;
}

@keyframes glitch {
  0%, 100% { transform: translate(0); }
  20% { transform: translate(-2px, 2px); }
  40% { transform: translate(-2px, -2px); }
  60% { transform: translate(2px, 2px); }
  80% { transform: translate(2px, -2px); }
}

@keyframes glitch-1 {
  0%, 100% { transform: translate(0); }
  20% { transform: translate(2px, -2px); }
  40% { transform: translate(-2px, 2px); }
  60% { transform: translate(-2px, -2px); }
  80% { transform: translate(2px, 2px); }
}

@keyframes glitch-2 {
  0%, 100% { transform: translate(0); }
  20% { transform: translate(-2px, -2px); }
  40% { transform: translate(2px, -2px); }
  60% { transform: translate(2px, 2px); }
  80% { transform: translate(-2px, 2px); }
}

.cyber-subtitle {
  text-align: center;
  opacity: 0.8;
}

/* 标题装饰线 */
.cyber-title-lines {
  position: relative;
  height: 1px;
  margin: 1rem 0;
}

.cyber-line {
  position: absolute;
  top: 0;
  height: 1px;
  background: linear-gradient(90deg, transparent, var(--cyber-primary), transparent);
  animation: line-pulse 2s ease-in-out infinite;
}

.cyber-line.left {
  left: 0;
  width: 40%;
}

.cyber-line.right {
  right: 0;
  width: 40%;
}

@keyframes line-pulse {
  0%, 100% { opacity: 0.3; }
  50% { opacity: 1; }
}

/* 输入组样式 */
.cyber-input-group {
  margin-bottom: 1.5rem;
}

.cyber-label {
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin-bottom: 0.5rem;
}

.cyber-label-text {
  color: var(--cyber-primary);
  font-size: 0.75rem;
  font-weight: 600;
  letter-spacing: 0.1em;
  text-transform: uppercase;
}

.cyber-label-indicator {
  width: 8px;
  height: 8px;
  background: var(--cyber-primary);
  border-radius: 50%;
  animation: pulse 2s infinite;
}

@keyframes pulse {
  0%, 100% { opacity: 0.4; }
  50% { opacity: 1; }
}

/* 输入框容器 */
.cyber-input-container {
  position: relative;
  transition: all 0.3s ease;
}

.cyber-input-container.focused .cyber-input-glow {
  opacity: 1;
  animation: input-glow 1.5s ease-in-out infinite alternate;
}

.cyber-input-container.error .cyber-input-decoration {
  border-color: var(--cyber-error);
}

.cyber-input-container.error .cyber-input-glow {
  background: radial-gradient(ellipse at center, rgba(255, 0, 64, 0.3) 0%, transparent 70%);
  opacity: 0.8;
}

/* 输入框装饰 */
.cyber-input-decoration {
  position: absolute;
  inset: 0;
  border: 1px solid var(--cyber-border);
  pointer-events: none;
  transition: all 0.3s ease;
}

.input-corner {
  position: absolute;
  width: 10px;
  height: 10px;
  border: 1px solid var(--cyber-primary);
}

.input-corner.tl {
  top: -1px;
  left: -1px;
  border-right: none;
  border-bottom: none;
}

.input-corner.tr {
  top: -1px;
  right: -1px;
  border-left: none;
  border-bottom: none;
}

.input-corner.bl {
  bottom: -1px;
  left: -1px;
  border-right: none;
  border-top: none;
}

.input-corner.br {
  bottom: -1px;
  right: -1px;
  border-left: none;
  border-top: none;
}

/* 输入框图标 */
.cyber-input-icon {
  position: absolute;
  left: 12px;
  top: 50%;
  transform: translateY(-50%);
  color: var(--cyber-primary);
  z-index: 2;
  opacity: 0.7;
  transition: all 0.3s ease;
}

.cyber-input-container.focused .cyber-input-icon {
  opacity: 1;
  color: var(--cyber-primary);
  filter: drop-shadow(0 0 5px var(--cyber-primary));
}

/* 输入框 */
.cyber-input {
  width: 100%;
  height: 48px;
  padding: 0 48px 0 40px;
  background: rgba(0, 0, 0, 0.6);
  border: none;
  color: var(--cyber-primary);
  font-family: 'JetBrains Mono', monospace;
  font-size: 0.9rem;
  font-weight: 500;
  letter-spacing: 0.05em;
  outline: none;
  transition: all 0.3s ease;
  backdrop-filter: blur(10px);
}

.cyber-input::placeholder {
  color: rgba(0, 255, 255, 0.4);
  font-weight: 400;
  letter-spacing: 0.1em;
}

.cyber-input:focus::placeholder {
  opacity: 0.6;
  transform: translateX(5px);
}

/* 输入框发光效果 */
.cyber-input-glow {
  position: absolute;
  inset: -2px;
  background: radial-gradient(ellipse at center, rgba(0, 255, 255, 0.2) 0%, transparent 70%);
  opacity: 0;
  transition: all 0.3s ease;
  pointer-events: none;
  z-index: -1;
}

@keyframes input-glow {
  0% {
    background: radial-gradient(ellipse at center, rgba(0, 255, 255, 0.2) 0%, transparent 70%);
  }
  100% {
    background: radial-gradient(ellipse at center, rgba(0, 255, 255, 0.4) 0%, transparent 70%);
  }
}

/* 切换按钮 */
.cyber-toggle-btn {
  position: absolute;
  right: 12px;
  top: 50%;
  transform: translateY(-50%);
  color: var(--cyber-primary);
  background: none;
  border: none;
  cursor: pointer;
  opacity: 0.7;
  transition: all 0.3s ease;
  z-index: 2;
}

.cyber-toggle-btn:hover {
  opacity: 1;
  filter: drop-shadow(0 0 5px var(--cyber-primary));
}

/* 错误信息 */
.cyber-error {
  display: flex;
  align-items: center;
  margin-top: 0.5rem;
  color: var(--cyber-error);
  font-size: 0.75rem;
  font-weight: 500;
  letter-spacing: 0.05em;
}

.error-icon {
  margin-right: 0.5rem;
  animation: error-pulse 1s infinite;
}

.error-text {
  text-transform: uppercase;
}

@keyframes error-pulse {
  0%, 100% { opacity: 0.7; }
  50% { opacity: 1; }
}

/* 复选框组 */
.cyber-checkbox-group {
  margin: 1.5rem 0;
}

.cyber-checkbox-container {
  display: flex;
  align-items: center;
  cursor: pointer;
  user-select: none;
}

.cyber-checkbox {
  position: relative;
  width: 20px;
  height: 20px;
  margin-right: 12px;
  transition: all 0.3s ease;
}

.checkbox-inner {
  position: relative;
  width: 100%;
  height: 100%;
  border: 1px solid var(--cyber-border);
  background: rgba(0, 0, 0, 0.6);
  transition: all 0.3s ease;
  display: flex;
  align-items: center;
  justify-content: center;
}

.cyber-checkbox.checked .checkbox-inner {
  border-color: var(--cyber-primary);
  background: rgba(0, 255, 255, 0.1);
}

.checkbox-glow {
  position: absolute;
  inset: -2px;
  background: radial-gradient(circle, rgba(0, 255, 255, 0.3) 0%, transparent 70%);
  opacity: 0;
  transition: all 0.3s ease;
}

.cyber-checkbox.checked .checkbox-glow {
  opacity: 1;
  animation: checkbox-glow 1.5s ease-in-out infinite alternate;
}

.checkbox-icon {
  width: 12px;
  height: 12px;
  color: var(--cyber-primary);
  filter: drop-shadow(0 0 3px var(--cyber-primary));
}

@keyframes checkbox-glow {
  0% { opacity: 0.5; }
  100% { opacity: 1; }
}

.cyber-checkbox-label {
  color: var(--cyber-primary);
  font-size: 0.8rem;
  font-weight: 500;
  letter-spacing: 0.05em;
  text-transform: uppercase;
  opacity: 0.8;
  transition: all 0.3s ease;
}

.cyber-checkbox-container:hover .cyber-checkbox-label {
  opacity: 1;
}

/* 按钮容器 */
.cyber-button-container {
  margin: 2rem 0 1.5rem 0;
  position: relative;
}

.cyber-button {
  position: relative;
  width: 100%;
  height: 56px;
  background: none;
  border: none;
  cursor: pointer;
  overflow: hidden;
  transition: all 0.3s ease;
  font-family: 'JetBrains Mono', monospace;
  outline: none;
}

.cyber-button:disabled {
  cursor: not-allowed;
  opacity: 0.7;
}

.button-bg {
  position: absolute;
  inset: 0;
  background: linear-gradient(135deg,
    rgba(0, 255, 255, 0.1) 0%,
    rgba(0, 100, 255, 0.1) 50%,
    rgba(255, 0, 255, 0.1) 100%);
  transition: all 0.3s ease;
}

.cyber-button:hover:not(:disabled) .button-bg {
  background: linear-gradient(135deg,
    rgba(0, 255, 255, 0.2) 0%,
    rgba(0, 100, 255, 0.2) 50%,
    rgba(255, 0, 255, 0.2) 100%);
}

.button-border {
  position: absolute;
  inset: 0;
  border: 1px solid var(--cyber-border);
  transition: all 0.3s ease;
}

.cyber-button:hover:not(:disabled) .button-border {
  border-color: var(--cyber-primary);
  box-shadow:
    0 0 20px rgba(0, 255, 255, 0.3),
    inset 0 0 20px rgba(0, 255, 255, 0.1);
}

.button-content {
  position: relative;
  z-index: 2;
  display: flex;
  align-items: center;
  justify-content: center;
  height: 100%;
  color: var(--cyber-primary);
  font-size: 0.9rem;
  font-weight: 600;
  letter-spacing: 0.1em;
  text-transform: uppercase;
}

.button-text {
  transition: all 0.3s ease;
}

.cyber-button:hover:not(:disabled) .button-text {
  text-shadow: 0 0 10px var(--cyber-primary);
}

.button-glow {
  position: absolute;
  inset: -2px;
  background: radial-gradient(ellipse at center, rgba(0, 255, 255, 0.2) 0%, transparent 70%);
  opacity: 0;
  transition: all 0.3s ease;
}

.cyber-button:hover:not(:disabled) .button-glow {
  opacity: 1;
  animation: button-glow 1.5s ease-in-out infinite alternate;
}

@keyframes button-glow {
  0% { opacity: 0.5; }
  100% { opacity: 1; }
}

/* 加载动画 */
.loading-spinner {
  display: flex;
  align-items: center;
  justify-content: center;
  margin-right: 8px;
}

.spinner-ring {
  width: 16px;
  height: 16px;
  border: 2px solid transparent;
  border-top: 2px solid var(--cyber-primary);
  border-radius: 50%;
  animation: spin 1s linear infinite;
}

.spinner-ring:nth-child(2) {
  animation-delay: 0.1s;
  margin-left: -12px;
  border-top-color: var(--cyber-secondary);
}

.spinner-ring:nth-child(3) {
  animation-delay: 0.2s;
  margin-left: -12px;
  border-top-color: var(--cyber-accent);
}

@keyframes spin {
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
}

/* 状态栏 */
.cyber-status-bar {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-top: 1.5rem;
  padding-top: 1rem;
  border-top: 1px solid rgba(0, 255, 255, 0.2);
}

.status-indicator {
  display: flex;
  align-items: center;
  font-size: 0.7rem;
  font-weight: 500;
  letter-spacing: 0.05em;
  text-transform: uppercase;
  opacity: 0.7;
}

.status-dot {
  width: 6px;
  height: 6px;
  border-radius: 50%;
  margin-right: 6px;
  background: rgba(255, 255, 255, 0.3);
  transition: all 0.3s ease;
}

.status-dot.active {
  background: var(--cyber-accent);
  box-shadow: 0 0 10px var(--cyber-accent);
  animation: status-pulse 2s ease-in-out infinite;
}

.status-text {
  color: var(--cyber-primary);
}

@keyframes status-pulse {
  0%, 100% { opacity: 0.7; }
  50% { opacity: 1; }
}

/* 响应式设计 */
@media (max-width: 480px) {
  .cyber-container {
    max-width: 100%;
    margin: 1rem;
    padding: 1.5rem;
  }

  .cyber-title {
    font-size: 1.5rem;
  }

  .cyber-input {
    height: 44px;
    font-size: 0.85rem;
  }

  .cyber-button {
    height: 48px;
  }
}

/* 性能优化 */
* {
  transform: translateZ(0);
  backface-visibility: hidden;
}
</style>