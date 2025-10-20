<template>
  <div class="flex flex-col h-screen bg-green-50 items-center justify-center view-account">
		<h1 class="text-2xl md:text-4xl font-bold text-indigo-900">小墨通用后台管理系统 V1.0</h1>
    <div class="md:flex bg-gray-100 rounded-xl shadow-2xl p-8 md:p-0 mt-10">
      <!-- <img
        class="w-32 h-32 md:w-48 md:h-auto rounded-full md:rounded-xl mx-auto"
        src="@/assets/images/login-logo.jpg"
        alt=""
        width="384"
        height="512"
      /> -->
      <div class="pt-6 md:p-8 space-y-4">
        <div class="text-3xl text-center font-black text-indigo-900">
          用户登录
        </div>
        <div class="font-medium">
          <n-form
            ref="loginFormRef"
            label-placement="left"
            size="large"
            :model="loginForm"
            :rules="loginRules"
          >
            <n-form-item path="userName">
              <n-input
                v-model:value="loginForm.userName"
                placeholder="请输入用户名"
              >
                <template #prefix>
                  <n-icon size="18" color="#808695">
                    <PersonOutline />
                  </n-icon>
                </template>
              </n-input>
            </n-form-item>
            <n-form-item path="password">
              <n-input
                v-model:value="loginForm.password"
                type="password"
                show-password-on="click"
                placeholder="请输入密码"
              >
                <template #prefix>
                  <n-icon size="18" color="#808695">
                    <LockClosedOutline />
                  </n-icon>
                </template>
              </n-input>
            </n-form-item>
            <n-form-item>
              <n-checkbox v-model:checked="autoLogin">自动登录</n-checkbox>
            </n-form-item>
            <n-form-item>
              <n-button
                type="primary"
                @click="handleLogin"
                size="large"
                :loading="loading"
                block
              >登录
              </n-button>
            </n-form-item>
          </n-form>
        </div>
      </div>
    </div>
	</div>
</template>
 
<script setup lang="ts">
	import { ref, reactive } from 'vue'
	import { PersonOutline, LockClosedOutline } from '@vicons/ionicons5'
 
	const autoLogin = ref(true)
	const loading = ref(false) // 加载图标 默认false
 
	const loginForm = reactive({
		userName: 'xiaomo',
		password: '123456',
		isCaptcha: true
	})
 
	const loginRules = {
		userName: { required: true, message: '请输入用户名', trigger: 'blur' },
		password: { required: true, message: '请输入密码', trigger: 'blur' }
	}
 
	const handleLogin = (e: any) => {
		console.log(111)
	}
</script>
 
<style scoped>
@media (min-width: 768px) {
  .view-account {
    background-image: url('@/assets/images/login.svg');
    background-repeat: no-repeat;
    background-position: 50%;
    background-size: 100%;
  }
}
</style>