### 目标

 - 封装请求
 - 封装响应
 - 响应处理
    - 网络异常的处理
    - 后台返回的业务异常的处理
    - 处理正常响应

### 文件结构
- src
    - app
        - model        定义服务器响应的结构
            - def      定义服务器返回的业务数据
                - trainee.def.ts
            - dto      定义服务器返回的响应数据
                - response.base.ts 基类
                - trainee.dto.ts 具体的业务响应数据
        - services
            - base.service.ts 向服务器发送请求的基类
            - trainee.service.ts 具体的业务请求的 service 
        - trainess
            - trainee.component.ts 

### 封装请求
### 封装响应
#### response.base.ts
```ts
export interface ResponseBase{
    code: number;
    msg: string;
    payLoad: any;
}
```
#### trainee.dto.ts
```ts
export interface TraineeDto extends ResponseBase{
    payLoad:TraineeDef;     
}
```
### 响应处理

```ts
this.traineeService.sign(traineId)
    .pipe(
      catchError(this.traineeService.handleHttpError),
      this.traineeService.handleRespError)
    .subscribe({ 
        next: (trainDto) => this.updateTraineesSign(trainDto),
        error: (e) => this.openErr(e)
      }
    );
```
### 异常处理
base.service.ts
#### 
```ts
import { HttpErrorResponse } from "@angular/common/http";
import { Observable, switchMap } from "rxjs";
import { throwError } from "rxjs/internal/observable/throwError";
import { ResponseBase } from '../model/dto/response/response.base'

export class BaseService{
    ## 处理网络或服务器异常
    handleHttpError(error: HttpErrorResponse){
        if (error.status === 0) {
          // A client-side or network error occurred. Handle it accordingly.
          console.error('An error occurred:', error.error);
        } else {
          // The backend returned an unsuccessful response code.
          // The response body may contain clues as to what went wrong.
          console.error(
            `Backend returned code ${error.status}, body was: `, error.error);
        }
        // Return an observable with a user-facing error message.
        return throwError(() => new Error('Something bad happened; please try again later.'));
      }
      ## 处理业务数据返回异常
      handleRespError(resp:Observable<ResponseBase>):Observable<ResponseBase>{
        return resp.pipe(
          switchMap((res) => {
            if (res.code != 200) { 
              return throwError(() => new Error(res.msg)); 
            }
            return resp;
          })
        );
      }
}
```

