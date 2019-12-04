# AidlDemo


1.server 端注册的service 如果允许让其他进程来访问，需要设置 android:export = true (service 包含intent-filter的时候，export 默认也为true)

2.client 和 server 工程包路径可以不相同，但是client端的aidl文件所在的包路径是要和server端aidl文件保持一致！
可以直接通过将server端aidl整个文件夹拷贝的方式给client端集成

3.client 绑定service时，setPackage 包名应该为server端项目的包名（当aidl包名和项目包名不一致时需要注意的点！,默认生成aidl文件就是包名，但是后期有可能修改项目的包名，修改时一定修改setPackage的值）
