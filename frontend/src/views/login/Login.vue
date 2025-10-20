<script setup>
import LoginScene from '@/views/login/component/LoginScene.vue';
import { OrbitControls } from '@tresjs/cientos';
import { Text3D ,Stars} from '@tresjs/cientos';

</script>
<template>
    <TresCanvas window-size>
        <OrbitControls/>
        <TresPerspectiveCamera :position="[0, 0, 5]" />
        <TresMesh>
            <LoginScene/>
        </TresMesh>
        <Stars></Stars>
    </TresCanvas>
</template>
<style>

</style>