import { createRouter, createWebHistory } from 'vue-router';
import Index from '../views/Index.vue';

const routes = [
   { 
    path: '/', 
    name: 'Home', 
    component: Index
    },
   { 
    path: '/login', 
    name: 'Login', 
    component: ()=>import('@/views/Login.vue')
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