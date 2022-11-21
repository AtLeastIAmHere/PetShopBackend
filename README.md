# petshop
## 11.15

1. 完成**登录接口**
   ```
   petshop/login
   ```

   传入参数：

   ```json
   {
       "account": "Rose123",
       "password": "123",
       "type":		"1"		#账户类型，1表示用户，2表示商店方，3表示供货商
   }
   ```

   验证数据库，返回 登录成功 或 账号密码失败提示

2. **更新**mysql数据库结构数据，最新sql文件在/resources/doc下




## 11.20
1. 商店管理员接口文档
   ```
   https://console-docs.apipost.cn/preview/a341ca4015266f0a/c06d8fc1eaecd775
   ```
2. 供应商接口文档
   ```
   https://console-docs.apipost.cn/preview/cc87e0cbba56f59a/8609fedc60dcbcf6
   ```

## 11.21

1. 修复用户确认收货无法保存的bug
2. 修复测试中已有的bug
