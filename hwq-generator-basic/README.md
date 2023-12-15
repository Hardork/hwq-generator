## 命令模式
- 命令: GenerateCommand等多个命令类中的run或call方法
- 具体命令：每一个子命令类
- 调用方：CommandExecutor
- 接收者：代码生成器类`MainGenerator`类（实际执行功能的类）
- 客户端：主程序`Main`