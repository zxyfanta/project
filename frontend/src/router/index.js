import { createRouter, createWebHistory } from 'vue-router';
import Index from '../views/Index.vue';
import Login from '../views/login/Login.vue';

const routes = [
   { 
    path: '/', 
    name: 'Home', 
    component: Index
    },
   { 
    path: '/login', 
    name: 'Login', 
    component:Login 
   },
   { 
    path: '/major-code', 
    name: 'Major-code', 
    component: ()=>import('@/views/MajorCodeView.vue')
   }
];
const router = createRouter({
   history: createWebHistory(),
   routes,
});
export default router;