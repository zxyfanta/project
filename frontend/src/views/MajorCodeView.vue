<template>
    <el-table :data="tableData" stripe style="width: 100%">

        <el-table-column prop="id" label="编号" width="180" />
        <el-table-column prop="affiliatedCollege" label="学院" width="180" />
        <el-table-column prop="majorCode" label="专业编号" width="180" />
        <el-table-column prop="majorName" label="专业名称" width="180" />
        <el-table-column prop="educationalSystem" label="学制" />
        <el-table-column prop="educationalLevel" label="学年" />
    </el-table>
</template>

<script>
export default {
    tableData=[],
    mounted(){

    },
    initData(){
        axios.get('http://localhost:8080/api/major-codes')
        .then(response=>{
            console.log(response.data,"请求数据")
            this.tableData=response.data
        })

    }

}
</script>

<style>

</style>