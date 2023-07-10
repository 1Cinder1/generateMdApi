#### 1.1 getHistoryPredict

| 接口 | /uaa/predict/heart-predict-history                                         |
| ---- | ------------------------------------------------------------ |
| 描述 | 心脏病预测历史数据                                                 |
| 验证 | Token，客户端验证，参数：<br />Header中：<br />**Authorization:** ==Bearer {token} |
| 方法 | GET                                                         |

**Request**
| 参数名        | 类型   | 是否必须 | 参数位置    | 描述           |
| ------------- | ------ | -------- | ----------- | -------------- |
| Authorization | String  | Y        | header     | 用户Token，Bearer协议 

**Response**


| 参数名         | 类型       | 是否必须 | 描述                        |
| -------------- | ---------- | -------- | --------------------------- |
| success           | Integer | Y        | null                    |
| code           | Long | Y        | null                    |
| message           | String | Y        | null                    |
| data           | Object | Y        | null                    |


#### 1.2 getStokeHisPredict

| 接口 | /uaa/predict/stroke-predict-history                                         |
| ---- | ------------------------------------------------------------ |
| 描述 | 中风预测历史数据                                                 |
| 验证 | Token，客户端验证，参数：<br />Header中：<br />**Authorization:** ==Bearer {token} |
| 方法 | GET                                                         |

**Request**
| 参数名        | 类型   | 是否必须 | 参数位置    | 描述           |
| ------------- | ------ | -------- | ----------- | -------------- |
| Authorization | String  | Y        | header     | 用户Token，Bearer协议 

**Response**


| 参数名         | 类型       | 是否必须 | 描述                        |
| -------------- | ---------- | -------- | --------------------------- |
| success           | Integer | Y        | null                    |
| code           | Long | Y        | null                    |
| message           | String | Y        | null                    |
| data           | Object | Y        | null                    |


