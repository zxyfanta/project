import axios from 'axios'
import { ElMessage } from 'element-plus'

const axiosRequest=axios.create({
    // baseURL:"http://localhost:8080",
    timeout:5000,
    headers:{
        "Content-Type": 'application/json;charset=utf-8'
    }
})

// 如果使用request对象进行请求的时候，对于发出去的请求，我们统一处理

axiosRequest.interceptors.request.use(
    (config)=>{
        const token=localStorage.getItem('token')
        if(token){
            config.headers.Authorization='Bearer ${token}'
        }
        return config
    },
    (error)=>{
        ElMessage.error("请求信息出错，"+error.message)
        return Promise.reject(error);
    }
)

// 后端守卫
axiosRequest.interceptors.response.use(
    (response)=>{
        //将后端的json数据中的data存储到res里面
        const res=response.data
        console.log("res",res);
        
        if(res.code===200){
            console.log("res.data",res.data);
            return res.data
        }
        ElMessage.error(res.msg || "操作失败")
        return  Promise.reject(new Error(res.msg || 'error'));
    },
    (error)=>{
        if(error.response){
            const status=error.response.status
            switch(status){
                case 401:
                    // 干掉令牌
                    localStorage.removeItem("token")
                    ElMessage.error("登录已过期，请重新登录")
                    break
                case 403:
                    ElMessage.error("没有访问权限")
                    break
                case 500:
                    ElMessage.error("服务器内部错误")
                    break
                default:
                    ElMessage.error("请求错误 ${status}")
            }
        }else if (error.request){
            ElMessage.error("网络错误，请检查网络连接")
        }else{
            ElMessage.error("请求错误 ${status}")
        }
        return Promise.reject(error)
    }
)

export default axiosRequest;