<template>
    <Html
    center
    transform
    :distance-factor="4"
    :position="[0, 0, 0.65]"
    :scale="[0.75, 0.75, 0.75]"
    >
        <LoginForm></LoginForm>
    </Html> 
</template>

<script setup>
import {ref ,onMounted} from 'vue'
import { TresCanvas } from '@tresjs/core';
import {useLoop} from '@tresjs/core';
import { Html } from '@tresjs/cientos';
import LoginForm from './LoginForm.vue';

const startRef=ref(null)
const planetsRef=ref([])
const {onBeforeRender,onRender}=useLoop()

const createStars=(count=5000)=>{
    const positions=new Float32Array(count*3)
    const sizes=new Float32Array(count)
    for(let i=0;i<count;i++){
        const i3=i*3;
        positions[i3]=(Math.random()-0.5)*2000
        positions[i3+1]=(Math.random()-0.5)*2000
        positions[i3+2]=(Math.random()-0.5)*2000
        sizes[i]=Math.random()*0.5+0.1
    }
    return {
        position:{
            array:positions,itemSize:3
        },
        size:{
            array:sizes,itemSize:1
        }
    }
}
const startsAttributes=createStars(8000);
onBeforeRender(({delta})=>{
    if(startRef.value){
        startRef.value.rotation.y+=delta*0.05
    }
});
</script>

<style>

</style>