
/*注册表单的js校验*/
var formobj={
	"checkForm":function(){
		//1.非空校验				
		var res1=this.checkNull("uname", "用户名不能为空！");
		var res2=this.checkNull("upwd", "密码不能为空！");
		var res3=this.checkNull("upwd2", "确认密码不能为空！");
		var res5=this.checkNull("email", "邮箱不能为空！");
		var res6=this.checkNull("valistr", "验证码不能为空！");
		var res7=this.checkPassword("upwd","两次密码输入不一致");
		var res8=this.checkEmail("email","邮箱格式不正确！");
		var res9=this.checkNull("uphone","电话号码不能为空！");
		return res1 && res2 && res3 && res5 && res6 && res7 && res8 && res9;				
	},
	"checkNull":function(name,msg){
		var value=$("input[name='"+name+"']").val();  
		
		if(value.trim()==""){
			this.setMsg(name, msg);
			return false;
		}
		return true;
	},
	/* 设置错误提示消息  */
	"setMsg":function(name,msg){
		alert(msg);
		
	},
	
	//2.两次密码是否一致校验
	"checkPassword":function(name,msg){
		var pwd=$("input[name='"+name+"2']").val().trim();
		var pwd2=$("input[name='"+name+"']").val().trim();
		
	  	if( pwd!="" && pwd2!=""){
	  		//清空之前的消息。
//				this.setMsg(name+"2","");
	  		if(pwd!= pwd2){
				this.setMsg(name+"2", msg);
				return false;
			}
	  	}
	  	return true;
	},
	//3.邮箱格式校验
	"checkEmail":function(name,msg){
		var email=$("input[name='"+name+"']").val().trim();
		var regExp=/^\w+@\w+(\.\w+)+$/;
		if(email!=""){
			if(!regExp.test(email)){
				this.setMsg(name, msg);
				return false;
			}
		}
		return true;
	}
	
	
};




