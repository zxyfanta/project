<template>
    <div>
        <el-button
        @click="insertMajorCode"
        >添加数据</el-button>
        <el-table :data="tableData" stripe style="width: 100%">
            <el-table-column prop="id" label="编号" width="180" />
            <el-table-column prop="affiliatedCollege" label="学院" width="180" />
            <el-table-column prop="majorCode" label="专业编号" width="180" />
            <el-table-column prop="majorName" label="专业名称" width="180" />
            <el-table-column prop="educationalSystem" label="学制" />
            <el-table-column prop="educationalLevel" label="学年" />
        </el-table>
    </div>
</template>

<script>
import axiosRequest from '@/utils/request'
export default {
    data(){
        return {
            tableData:[]
        }
    },
    methods:{
        async initData(){
            const data=await axiosRequest.get("/api/major-codes")
            console.log('mydata',data);
            this.tableData=data
        },
        async insertMajorCode(){
            await axiosRequest.post("/api/major-codes",{
                "affiliatedCollege": "李四学院",
                "majorCode": 999, 
                "majorName": "刑法",
                "educationalSystem": 8,
                "educationalLevel": "本硕连读"
            })
            this.initData()
        }
    },
    mounted(){
        this.initData()

    },

}
</script>

<style>

</style>