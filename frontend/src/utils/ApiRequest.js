import axios from 'axios'
const apiRequest=axios.create({
  baseURL:'/api',
  timeout:10000
})

export default apiRequest