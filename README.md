# MedicalMS
大一下的暑假，我的第一个项目，基于JavaFx+Maven的医疗管理项目。是对我的JAVA第一阶段学习的成果展示。
医疗管理系统 - 项目介绍
🎯 项目概述
万和医疗管理系统是一个基于 JavaFX 开发的桌面端医疗管理软件，旨在为医院提供一体化的管理解决方案。系统支持管理员和医生两种角色，涵盖患者管理、医生管理、药品管理、挂号就诊、AI智能辅助等核心功能模块。
 
🛠️ 技术栈
核心技术
Java 17 - 开发语言
JavaFX 17.0.6 - 图形界面框架
Maven - 项目构建与依赖管理
数据库
MySQL 8.0.33 - 关系型数据库
Apache Commons DBCP2 - 数据库连接池
JDBC - 数据访问层
AI 集成
LangChain4j 0.32.0 - AI 框架
智谱 AI（GLM-4）- 智能对话
图像生成模型
向量嵌入（BGE）
其他依赖
Jackson 2.16.1 - JSON 处理
Fastjson 1.2.83 - JSON 序列化
Tinylog 2.6.2 - 日志框架
BootstrapFX 0.4.0 - UI 样式增强
JUnit 5.9.2 - 单元测试
Guava、Javassist、Reflections - 工具库
 
📁 项目架构
**分层架构设计
├── controller/          # 控制层 - FXML页面控制器
├── service/            # 业务逻辑层
│   └── impl/          # 服务实现类
├── dao/                # 数据访问层
│   ├── impl/          # DAO实现类
│   └── mapper/        # 数据映射器
├── entity/             # 实体类
├── vo/                 # 视图对象（View Object）
│   └── mapper/        # VO映射器
├── comm/               # 通用组件
│   ├── anno/          # 自定义注解
│   ├── controller/    # 基础控制器
│   ├── dao/           # 基础DAO
│   ├── exception/     # 异常处理
│   ├── factory/       # Bean工厂
│   ├── ui/            # UI管理工具
│   └── util/          # 工具类
└── util/               # 工具类**


👥 核心功能模块
1. 用户认证模块
登录系统 (LoginController)
支持管理员和医生双角色登录
身份验证与权限控制
会话管理（LoginInfoUtil）
2. 管理员功能模块
管理员管理 (AdminAddController)
添加新管理员
管理员信息维护
医生管理
DoctorAddController - 医生信息录入
DoctorManagerController - 医生列表与管理
DoctorViewController - 医生信息查看
患者管理 (PatientManagerController)
患者信息查询
患者档案管理
药品管理
MedicineTypeController - 药品分类管理
MedicineAddController - 药品信息添加
MedManagerController - 药品库存管理
挂号管理 (RegistrationController)
患者挂号登记
挂号信息管理
3. 医生功能模块
就诊管理 (SeeDocController)
患者就诊记录
诊断信息管理
处方管理 (PrescribeController)
开具处方
处方查询
4. AI 智能辅助模块 (AiController)
智能问答
集成智谱 GLM-4 大模型
医疗知识咨询
智能对话交互
图像生成
AI 图像生成功能
医学图像辅助
5. 主界面导航 (MainController)
动态菜单显示（根据角色权限）
用户信息展示
模块快速切换
注销与退出功能

💾 数据库设计
数据库名称: web138_project
核心实体表:
Admin - 管理员表
Doctor - 医生表
Patient - 患者表
Medicine - 药品表
MedicineType - 药品分类表
MedicineSup - 药品供应商表
Registration - 挂号表
See_Doctor - 就诊记录表
Dept - 科室表
Education - 学历表
Job - 职称表
Login - 登录凭证表

🎨 界面资源
FXML 页面 (15个):
login.fxml - 登录页面
main.fxml - 主页面
adminadd.fxml - 管理员添加
docadd.fxml - 医生添加
docmanager.fxml - 医生管理
doctorview.fxml - 医生查看
patientmanager.fxml - 患者管理
medicineadd.fxml - 药品添加
medicinetype.fxml - 药品分类
medicinemanager.fxml - 药品管理
registration.fxml - 挂号管理
seedoctor.fxml - 就诊管理
prescribe.fxml - 处方管理
ai.fxml - AI 助手
hello-view.fxml - 欢迎页面
图片资源: 13张背景图和头像图片

✅ 测试覆盖
项目包含完整的单元测试：
DAO 层测试: 8个测试类
Service 层测试: 4个测试类
Controller 测试: 2个测试类
工具类测试: JDBC 工具测试

📊 项目亮点
✨ 现代化技术栈: Java 17 + JavaFX 17，紧跟技术前沿
🤖 AI 集成: 创新性集成 LangChain4j 和智谱 AI，提供智能医疗辅助
🏗️ 良好架构: 分层清晰，采用 MVC 模式和工厂模式
🔐 权限控制: 基于角色的访问控制（RBAC）
🎯 完整业务: 覆盖医院管理核心业务流程
📝 充分测试: 完善的单元测试覆盖
🛠️ 工具封装: 丰富的工具类提高开发效率
