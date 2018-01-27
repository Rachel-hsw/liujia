    function check(){
           var txtid=document.form1.examID.value;
           if(txtid.search("^[A-Za-z0-9]+$")!=0 ){
             alert("请输入正确的身份证号");
             form1.examID.focus();
             return false;
             }
           if(form1.password.value==""){
             alert("密码不能为空");
             form1.password.focus();
             return false;
             }
           var txt=document.form1.email.value;
           if(txt.search("^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$")!=0){
             alert("请输入正确的电子邮件地址");
             document.form1.email.select();
             return false;
             }
    }
