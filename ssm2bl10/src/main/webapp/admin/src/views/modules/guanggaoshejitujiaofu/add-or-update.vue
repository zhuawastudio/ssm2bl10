<template>
  <div class="addEdit-block">
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
	  :style="{backgroundColor:addEditForm.addEditBoxColor}"
    >
      <el-row>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="广告名称" prop="guanggaomingcheng">
          <el-input v-model="ruleForm.guanggaomingcheng" 
              placeholder="广告名称" clearable  :readonly="ro.guanggaomingcheng"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="广告名称" prop="guanggaomingcheng">
              <el-input v-model="ruleForm.guanggaomingcheng" 
                placeholder="广告名称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="24">  
        <el-form-item class="upload" v-if="type!='info' && !ro.guanggaofengmian" label="广告封面" prop="guanggaofengmian">
          <file-upload
          tip="点击上传广告封面"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.guanggaofengmian?ruleForm.guanggaofengmian:''"
          @change="guanggaofengmianUploadChange"
          ></file-upload>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.guanggaofengmian" label="广告封面" prop="guanggaofengmian">
            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.guanggaofengmian.split(',')" :src="item" width="100" height="100">
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="投放渠道" prop="toufangqudao">
          <el-input v-model="ruleForm.toufangqudao" 
              placeholder="投放渠道" clearable  :readonly="ro.toufangqudao"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="投放渠道" prop="toufangqudao">
              <el-input v-model="ruleForm.toufangqudao" 
                placeholder="投放渠道" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="广告要求" prop="guanggaoyaoqiu">
          <el-input v-model="ruleForm.guanggaoyaoqiu" 
              placeholder="广告要求" clearable  :readonly="ro.guanggaoyaoqiu"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="广告要求" prop="guanggaoyaoqiu">
              <el-input v-model="ruleForm.guanggaoyaoqiu" 
                placeholder="广告要求" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="交付费用" prop="jiaofufeiyong">
          <el-input v-model="ruleForm.jiaofufeiyong" 
              placeholder="交付费用" clearable  :readonly="ro.jiaofufeiyong"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="交付费用" prop="jiaofufeiyong">
              <el-input v-model="ruleForm.jiaofufeiyong" 
                placeholder="交付费用" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="24">  
        <el-form-item class="upload" v-if="type!='info' && !ro.shejitu" label="设计图" prop="shejitu">
          <file-upload
          tip="点击上传设计图"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.shejitu?ruleForm.shejitu:''"
          @change="shejituUploadChange"
          ></file-upload>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.shejitu" label="设计图" prop="shejitu">
            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.shejitu.split(',')" :src="item" width="100" height="100">
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="24">  
        <el-form-item class="upload" v-if="type!='info'" label="设计图文件" prop="shejituwenjian">
          <file-upload
          tip="点击上传设计图文件"
          action="file/upload"
          :limit="1"
          :multiple="true"
          :fileUrls="ruleForm.shejituwenjian?ruleForm.shejituwenjian:''"
          @change="shejituwenjianUploadChange"
          ></file-upload>
        </el-form-item>  
        <div v-else>
          <el-form-item v-if="ruleForm.shejituwenjian" label="设计图文件" prop="shejituwenjian">
            <el-button type="text" size="small" @click="download(ruleForm.shejituwenjian)">下载</el-button>
          </el-form-item>
        </div>    
      </el-col>      
      <el-col :span="12">
        <el-form-item class="date" v-if="type!='info'" label="提交时间" prop="tijiaoshijian">
            <el-date-picker
                value-format="yyyy-MM-dd HH:mm:ss"
                v-model="ruleForm.tijiaoshijian" 
                type="datetime"
                placeholder="提交时间">
            </el-date-picker>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" v-if="ruleForm.tijiaoshijian" label="提交时间" prop="tijiaoshijian">
              <el-input v-model="ruleForm.tijiaoshijian" 
                placeholder="提交时间" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="客户账号" prop="kehuzhanghao">
          <el-input v-model="ruleForm.kehuzhanghao" 
              placeholder="客户账号" clearable  :readonly="ro.kehuzhanghao"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="客户账号" prop="kehuzhanghao">
              <el-input v-model="ruleForm.kehuzhanghao" 
                placeholder="客户账号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="客户姓名" prop="kehuxingming">
          <el-input v-model="ruleForm.kehuxingming" 
              placeholder="客户姓名" clearable  :readonly="ro.kehuxingming"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="客户姓名" prop="kehuxingming">
              <el-input v-model="ruleForm.kehuxingming" 
                placeholder="客户姓名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="广告商账号" prop="guanggaoshangzhanghao">
          <el-input v-model="ruleForm.guanggaoshangzhanghao" 
              placeholder="广告商账号" clearable  :readonly="ro.guanggaoshangzhanghao"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="广告商账号" prop="guanggaoshangzhanghao">
              <el-input v-model="ruleForm.guanggaoshangzhanghao" 
                placeholder="广告商账号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="广告商名称" prop="guanggaoshangmingcheng">
          <el-input v-model="ruleForm.guanggaoshangmingcheng" 
              placeholder="广告商名称" clearable  :readonly="ro.guanggaoshangmingcheng"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="广告商名称" prop="guanggaoshangmingcheng">
              <el-input v-model="ruleForm.guanggaoshangmingcheng" 
                placeholder="广告商名称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="制作商账号" prop="zhizuoshangzhanghao">
          <el-input v-model="ruleForm.zhizuoshangzhanghao" 
              placeholder="制作商账号" clearable  :readonly="ro.zhizuoshangzhanghao"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="制作商账号" prop="zhizuoshangzhanghao">
              <el-input v-model="ruleForm.zhizuoshangzhanghao" 
                placeholder="制作商账号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="制作商名称" prop="zhizuoshangmingcheng">
          <el-input v-model="ruleForm.zhizuoshangmingcheng" 
              placeholder="制作商名称" clearable  :readonly="ro.zhizuoshangmingcheng"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="制作商名称" prop="zhizuoshangmingcheng">
              <el-input v-model="ruleForm.zhizuoshangmingcheng" 
                placeholder="制作商名称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item v-if="type!='info'"  label="设计图内容" prop="shejituneirong">
                <editor 
                    style="min-width: 200px; max-width: 600px;"
                    v-model="ruleForm.shejituneirong" 
                    class="editor" 
                    action="file/upload">
                </editor>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.shejituneirong" label="设计图内容" prop="shejituneirong">
                    <span v-html="ruleForm.shejituneirong"></span>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
      <el-form-item class="btn">
        <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
        <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
        <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
    

  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
  data() {
    let self = this
    var validateIdCard = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!checkIdCard(value)) {
        callback(new Error("请输入正确的身份证号码"));
      } else {
        callback();
      }
    };
    var validateUrl = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isURL(value)) {
        callback(new Error("请输入正确的URL地址"));
      } else {
        callback();
      }
    };
    var validateMobile = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isMobile(value)) {
        callback(new Error("请输入正确的手机号码"));
      } else {
        callback();
      }
    };
    var validatePhone = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isPhone(value)) {
        callback(new Error("请输入正确的电话号码"));
      } else {
        callback();
      }
    };
    var validateEmail = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isEmail(value)) {
        callback(new Error("请输入正确的邮箱地址"));
      } else {
        callback();
      }
    };
    var validateNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isNumber(value)) {
        callback(new Error("请输入数字"));
      } else {
        callback();
      }
    };
    var validateIntNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isIntNumer(value)) {
        callback(new Error("请输入整数"));
      } else {
        callback();
      }
    };
    return {
	  addEditForm: {"btnSaveFontColor":"#fff","selectFontSize":"14px","btnCancelBorderColor":"#DCDFE6","inputBorderRadius":"4px","inputFontSize":"14px","textareaBgColor":"#fff","btnSaveFontSize":"14px","textareaBorderRadius":"4px","uploadBgColor":"#fff","textareaBorderStyle":"solid","btnCancelWidth":"88px","textareaHeight":"120px","dateBgColor":"#fff","btnSaveBorderRadius":"4px","uploadLableFontSize":"14px","textareaBorderWidth":"1px","inputLableColor":"#606266","addEditBoxColor":"#fff","dateIconFontSize":"14px","btnSaveBgColor":"rgba(36, 194, 205, 1)","uploadIconFontColor":"#8c939d","textareaBorderColor":"#DCDFE6","btnCancelBgColor":"#ecf5ff","selectLableColor":"#606266","btnSaveBorderStyle":"solid","dateBorderWidth":"1px","dateLableFontSize":"14px","dateBorderRadius":"4px","btnCancelBorderStyle":"solid","selectLableFontSize":"14px","selectBorderStyle":"solid","selectIconFontColor":"#C0C4CC","btnCancelHeight":"44px","inputHeight":"40px","btnCancelFontColor":"#606266","dateBorderColor":"#DCDFE6","dateIconFontColor":"#C0C4CC","uploadBorderStyle":"solid","dateBorderStyle":"solid","dateLableColor":"#606266","dateFontSize":"14px","inputBorderWidth":"1px","uploadIconFontSize":"28px","selectHeight":"40px","inputFontColor":"#606266","uploadHeight":"148px","textareaLableColor":"#606266","textareaLableFontSize":"14px","btnCancelFontSize":"14px","inputBorderStyle":"solid","btnCancelBorderRadius":"4px","inputBgColor":"#fff","inputLableFontSize":"14px","uploadLableColor":"#606266","uploadBorderRadius":"4px","btnSaveHeight":"44px","selectBgColor":"#fff","btnSaveWidth":"88px","selectIconFontSize":"14px","dateHeight":"40px","selectBorderColor":"#DCDFE6","inputBorderColor":"#DCDFE6","uploadBorderColor":"#DCDFE6","textareaFontColor":"#606266","selectBorderWidth":"1px","dateFontColor":"#606266","btnCancelBorderWidth":"1px","uploadBorderWidth":"1px","textareaFontSize":"14px","selectBorderRadius":"4px","selectFontColor":"#606266","btnSaveBorderColor":"#409EFF","btnSaveBorderWidth":"0px"},
      id: '',
      type: '',
      ro:{
	guanggaomingcheng : false,
	guanggaofengmian : false,
	toufangqudao : false,
	guanggaoyaoqiu : false,
	jiaofufeiyong : false,
	shejitu : false,
	shejituwenjian : false,
	shejituneirong : false,
	tijiaoshijian : false,
	kehuzhanghao : false,
	kehuxingming : false,
	guanggaoshangzhanghao : false,
	guanggaoshangmingcheng : false,
	zhizuoshangzhanghao : false,
	zhizuoshangmingcheng : false,
	sfsh : false,
	shhf : false,
	ispay : false,
      },
      ruleForm: {
        guanggaomingcheng: '',
        guanggaofengmian: '',
        toufangqudao: '',
        guanggaoyaoqiu: '',
        jiaofufeiyong: '',
        shejitu: '',
        shejituwenjian: '',
        shejituneirong: '',
        tijiaoshijian: '',
        kehuzhanghao: '',
        kehuxingming: '',
        guanggaoshangzhanghao: '',
        guanggaoshangmingcheng: '',
        zhizuoshangzhanghao: '',
        zhizuoshangmingcheng: '',
        shhf: '',
      },
      rules: {
          guanggaomingcheng: [
          ],
          guanggaofengmian: [
          ],
          toufangqudao: [
          ],
          guanggaoyaoqiu: [
          ],
          jiaofufeiyong: [
                { validator: validateIntNumber, trigger: 'blur' },
          ],
          shejitu: [
          ],
          shejituwenjian: [
          ],
          shejituneirong: [
          ],
          tijiaoshijian: [
          ],
          kehuzhanghao: [
          ],
          kehuxingming: [
          ],
          guanggaoshangzhanghao: [
          ],
          guanggaoshangmingcheng: [
          ],
          zhizuoshangzhanghao: [
          ],
          zhizuoshangmingcheng: [
          ],
          sfsh: [
          ],
          shhf: [
          ],
          ispay: [
          ],
      }
    };
  },
  props: ["parent"],
  computed: {
  },
  created() {
	this.ruleForm.tijiaoshijian = this.getCurDateTime()

	this.addEditStyleChange()
	this.addEditUploadStyleChange()
  },
  methods: {
    // 下载
    download(file){
      window.open(`${file}`)
    },
    // 初始化
    init(id,type) {
      if (id) {
        this.id = id;
        this.type = type;
      }
      if(this.type=='info'||this.type=='else'){
        this.info(id);
      }else if(this.type=='cross'){
        var obj = this.$storage.getObj('crossObj');
        for (var o in obj){
          if(o=='guanggaomingcheng'){
            this.ruleForm.guanggaomingcheng = obj[o];
	    this.ro.guanggaomingcheng = true;
            continue;
          }
          if(o=='guanggaofengmian'){
            this.ruleForm.guanggaofengmian = obj[o];
	    this.ro.guanggaofengmian = true;
            continue;
          }
          if(o=='toufangqudao'){
            this.ruleForm.toufangqudao = obj[o];
	    this.ro.toufangqudao = true;
            continue;
          }
          if(o=='guanggaoyaoqiu'){
            this.ruleForm.guanggaoyaoqiu = obj[o];
	    this.ro.guanggaoyaoqiu = true;
            continue;
          }
          if(o=='jiaofufeiyong'){
            this.ruleForm.jiaofufeiyong = obj[o];
	    this.ro.jiaofufeiyong = true;
            continue;
          }
          if(o=='shejitu'){
            this.ruleForm.shejitu = obj[o];
	    this.ro.shejitu = true;
            continue;
          }
          if(o=='shejituwenjian'){
            this.ruleForm.shejituwenjian = obj[o];
	    this.ro.shejituwenjian = true;
            continue;
          }
          if(o=='shejituneirong'){
            this.ruleForm.shejituneirong = obj[o];
	    this.ro.shejituneirong = true;
            continue;
          }
          if(o=='tijiaoshijian'){
            this.ruleForm.tijiaoshijian = obj[o];
	    this.ro.tijiaoshijian = true;
            continue;
          }
          if(o=='kehuzhanghao'){
            this.ruleForm.kehuzhanghao = obj[o];
	    this.ro.kehuzhanghao = true;
            continue;
          }
          if(o=='kehuxingming'){
            this.ruleForm.kehuxingming = obj[o];
	    this.ro.kehuxingming = true;
            continue;
          }
          if(o=='guanggaoshangzhanghao'){
            this.ruleForm.guanggaoshangzhanghao = obj[o];
	    this.ro.guanggaoshangzhanghao = true;
            continue;
          }
          if(o=='guanggaoshangmingcheng'){
            this.ruleForm.guanggaoshangmingcheng = obj[o];
	    this.ro.guanggaoshangmingcheng = true;
            continue;
          }
          if(o=='zhizuoshangzhanghao'){
            this.ruleForm.zhizuoshangzhanghao = obj[o];
	    this.ro.zhizuoshangzhanghao = true;
            continue;
          }
          if(o=='zhizuoshangmingcheng'){
            this.ruleForm.zhizuoshangmingcheng = obj[o];
	    this.ro.zhizuoshangmingcheng = true;
            continue;
          }
        }
      }
      // 获取用户信息
      this.$http({
        url: `${this.$storage.get('sessionTable')}/session`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          var json = data.data;
		if(json.zhizuoshangzhanghao!=''&&json.zhizuoshangzhanghao){
              		this.ruleForm.zhizuoshangzhanghao = json.zhizuoshangzhanghao
		}
		if(json.zhizuoshangmingcheng!=''&&json.zhizuoshangmingcheng){
              		this.ruleForm.zhizuoshangmingcheng = json.zhizuoshangmingcheng
		}
        } else {
          this.$message.error(data.msg);
        }
      });
    },
    // 多级联动参数
    info(id) {
      this.$http({
        url: `guanggaoshejitujiaofu/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
	//解决前台上传图片后台不显示的问题
	let reg=new RegExp('../../../upload','g')//g代表全部
	this.ruleForm.shejituneirong = this.ruleForm.shejituneirong.replace(reg,'../../../ssm2bl10/upload');
        } else {
          this.$message.error(data.msg);
        }
      });
    },
    // 提交
    onSubmit() {
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}


















      this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `guanggaoshejitujiaofu/${!this.ruleForm.id ? "save" : "update"}`,
            method: "post",
            data: this.ruleForm
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.$message({
                message: "操作成功",
                type: "success",
                duration: 1500,
                onClose: () => {
                  this.parent.showFlag = true;
                  this.parent.addOrUpdateFlag = false;
                  this.parent.guanggaoshejitujiaofuCrossAddOrUpdateFlag = false;
                  this.parent.search();
                  this.parent.contentStyleChange();
                }
              });
            } else {
              this.$message.error(data.msg);
            }
          });
        }
      });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.guanggaoshejitujiaofuCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    guanggaofengmianUploadChange(fileUrls) {
	this.ruleForm.guanggaofengmian = fileUrls;
			this.addEditUploadStyleChange()
    },
    shejituUploadChange(fileUrls) {
	this.ruleForm.shejitu = fileUrls;
			this.addEditUploadStyleChange()
    },
    shejituwenjianUploadChange(fileUrls) {
	this.ruleForm.shejituwenjian = fileUrls;
			this.addEditUploadStyleChange()
    },
	addEditStyleChange() {
	  this.$nextTick(()=>{
	    // input
	    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.inputHeight
	      el.style.color = this.addEditForm.inputFontColor
	      el.style.fontSize = this.addEditForm.inputFontSize
	      el.style.borderWidth = this.addEditForm.inputBorderWidth
	      el.style.borderStyle = this.addEditForm.inputBorderStyle
	      el.style.borderColor = this.addEditForm.inputBorderColor
	      el.style.borderRadius = this.addEditForm.inputBorderRadius
	      el.style.backgroundColor = this.addEditForm.inputBgColor
	    })
	    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.inputHeight
	      el.style.color = this.addEditForm.inputLableColor
	      el.style.fontSize = this.addEditForm.inputLableFontSize
	    })
	    // select
	    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.selectHeight
	      el.style.color = this.addEditForm.selectFontColor
	      el.style.fontSize = this.addEditForm.selectFontSize
	      el.style.borderWidth = this.addEditForm.selectBorderWidth
	      el.style.borderStyle = this.addEditForm.selectBorderStyle
	      el.style.borderColor = this.addEditForm.selectBorderColor
	      el.style.borderRadius = this.addEditForm.selectBorderRadius
	      el.style.backgroundColor = this.addEditForm.selectBgColor
	    })
	    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.selectHeight
	      el.style.color = this.addEditForm.selectLableColor
	      el.style.fontSize = this.addEditForm.selectLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
	      el.style.color = this.addEditForm.selectIconFontColor
	      el.style.fontSize = this.addEditForm.selectIconFontSize
	    })
	    // date
	    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.dateHeight
	      el.style.color = this.addEditForm.dateFontColor
	      el.style.fontSize = this.addEditForm.dateFontSize
	      el.style.borderWidth = this.addEditForm.dateBorderWidth
	      el.style.borderStyle = this.addEditForm.dateBorderStyle
	      el.style.borderColor = this.addEditForm.dateBorderColor
	      el.style.borderRadius = this.addEditForm.dateBorderRadius
	      el.style.backgroundColor = this.addEditForm.dateBgColor
	    })
	    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.dateHeight
	      el.style.color = this.addEditForm.dateLableColor
	      el.style.fontSize = this.addEditForm.dateLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
	      el.style.color = this.addEditForm.dateIconFontColor
	      el.style.fontSize = this.addEditForm.dateIconFontSize
	      el.style.lineHeight = this.addEditForm.dateHeight
	    })
	    // upload
	    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
	    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
	      el.style.width = this.addEditForm.uploadHeight
	      el.style.height = this.addEditForm.uploadHeight
	      el.style.borderWidth = this.addEditForm.uploadBorderWidth
	      el.style.borderStyle = this.addEditForm.uploadBorderStyle
	      el.style.borderColor = this.addEditForm.uploadBorderColor
	      el.style.borderRadius = this.addEditForm.uploadBorderRadius
	      el.style.backgroundColor = this.addEditForm.uploadBgColor
	    })
	    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.uploadHeight
	      el.style.color = this.addEditForm.uploadLableColor
	      el.style.fontSize = this.addEditForm.uploadLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
	      el.style.color = this.addEditForm.uploadIconFontColor
	      el.style.fontSize = this.addEditForm.uploadIconFontSize
	      el.style.lineHeight = iconLineHeight
	      el.style.display = 'block'
	    })
	    // 多文本输入框
	    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
	      el.style.height = this.addEditForm.textareaHeight
	      el.style.color = this.addEditForm.textareaFontColor
	      el.style.fontSize = this.addEditForm.textareaFontSize
	      el.style.borderWidth = this.addEditForm.textareaBorderWidth
	      el.style.borderStyle = this.addEditForm.textareaBorderStyle
	      el.style.borderColor = this.addEditForm.textareaBorderColor
	      el.style.borderRadius = this.addEditForm.textareaBorderRadius
	      el.style.backgroundColor = this.addEditForm.textareaBgColor
	    })
	    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
	      // el.style.lineHeight = this.addEditForm.textareaHeight
	      el.style.color = this.addEditForm.textareaLableColor
	      el.style.fontSize = this.addEditForm.textareaLableFontSize
	    })
	    // 保存
	    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
	      el.style.width = this.addEditForm.btnSaveWidth
	      el.style.height = this.addEditForm.btnSaveHeight
	      el.style.color = this.addEditForm.btnSaveFontColor
	      el.style.fontSize = this.addEditForm.btnSaveFontSize
	      el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
	      el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
	      el.style.borderColor = this.addEditForm.btnSaveBorderColor
	      el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
	      el.style.backgroundColor = this.addEditForm.btnSaveBgColor
	    })
	    // 返回
	    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
	      el.style.width = this.addEditForm.btnCancelWidth
	      el.style.height = this.addEditForm.btnCancelHeight
	      el.style.color = this.addEditForm.btnCancelFontColor
	      el.style.fontSize = this.addEditForm.btnCancelFontSize
	      el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
	      el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
	      el.style.borderColor = this.addEditForm.btnCancelBorderColor
	      el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
	      el.style.backgroundColor = this.addEditForm.btnCancelBgColor
	    })
	  })
	},
	addEditUploadStyleChange() {
		this.$nextTick(()=>{
		  document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
			el.style.width = this.addEditForm.uploadHeight
			el.style.height = this.addEditForm.uploadHeight
			el.style.borderWidth = this.addEditForm.uploadBorderWidth
			el.style.borderStyle = this.addEditForm.uploadBorderStyle
			el.style.borderColor = this.addEditForm.uploadBorderColor
			el.style.borderRadius = this.addEditForm.uploadBorderRadius
			el.style.backgroundColor = this.addEditForm.uploadBgColor
		  })
	  })
	},
  }
};
</script>
<style lang="scss">
.editor{
  height: 500px;
  
  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
}
.btn .el-button {
  padding: 0;
}
</style>
