<script setup>

import { ref ,onMounted} from 'vue'
import apiRequest from '../utils/ApiRequest'  
const tableData=ref([])
onMounted(()=>{
  getMajorCode()
})
const getMajorCode=async ()=>{
  const data=await apiRequest.get("/api/major-codes")
  tableData.value=data.data
}
const addMajorCode=async ()=>{
  await apiRequest.post("/api/major-codes",{
    "affiliatedcollege":'信息工程学院',
    "majorCode":'1001',
    "majorName":'信息工程',
    "name":'信息工程'
  },{
    headers: {
      'Content-Type': 'application/json'
    }
  }).then(()=>{
    getMajorCode()
  })
}

</script>

<template>
  <h1>ab</h1>
  <el-button type="primary" @click="addMajorCode">新增专业</el-button>
  <el-table :data="tableData" style="width: 100%">
    <el-table-column prop="id" label="ID" width="180" />
    <el-table-column prop="affiliatedcollege" label="所属学院" width="180" />
    <el-table-column prop="majorCode" label="专业代码" width="180" />
    <el-table-column prop="majorName" label="专业名称" width="180" />
    <el-table-column prop="name" label="专业名称" width="180" />
    <el-table-column prop="address" label="地址" />
  </el-table>
</template>

<style scoped>
.read-the-docs {
  color: #888;
}
</style>
