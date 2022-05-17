# Input 装饰器
父控件传递内容给子控件
## ChildComponent.ts
```ts
import { Component, OnInit, Input } from '@angular/core';

......

export class ChildComponent implements OnInit {

	@Input() childMessage: string | undefined;

	constructor() { }

	ngOnInit(): void {}

}
```
## ParentComponent.html
```html
<app-child [childMessage] = "'Hello from parent'"></app-child>
```

# Output装饰器
子控件传递内容给父控件
## ChildComponent.ts
```ts
import { Component, OnInit, Output, EventEmitter } from '@angular/core';

.....

export class ChildComponent implements OnInit {


	@Output() messageEvent = new EventEmitter<string>();

	constructor() { }

	ngOnInit(): void {}

	sendMessage(){
		this.messageEvent.emit("Hello From child");
	}
}
```
## ParentComponent.html
```html
<app-child (messageEvent)="receiveMessage($event)"></app-child>
```
# ViewChild
父控件中显示子控件的属性
## ChildComponent.ts
```ts
import { Component, OnInit} from '@angular/core';

....

export class ChildComponent implements OnInit {

	message: string = "this is child message";
	constructor() { }
	ngOnInit(): void {}
}
```
## ParentComponent.ts
```ts
import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';

import { ChildComponent } from '../child/child.component';

...... 

export class ParentComponent implements OnInit {

	@ViewChild(ChildComponent) child: any;

	constructor() { }

	ngOnInit(): void {}
  
	ngAfterViewInit(){
		alert(this.child.message)

	}

}
```
