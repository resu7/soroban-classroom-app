# soroban-classroom-app

このリポジトリでは、[私のWebサイト](https://www.resufactory.net/)で紹介している[そろばん教室アプリ](https://www.resufactory.net/yuza/?p=117)のソースコードを公開しています。

アプリの完成版とインストール手順を含めたzipファイルは[Googleドライブ](https://drive.google.com/file/d/1-ixNmLe1P8_29NK-4mRvHs6dXiQ1gIMI/view?usp=sharing)上で公開しています。<br>
・zipファイルのパスワード
```cmd
X@Jf+2V9EAEYKQTj
```

そろばん教室アプリは全部で以下の7つです。
- かずあそび
- ソロメージ
- ピラミッド計算
- フラッシュ暗算
- 九九博士マスター
- 日本一周
- 鬼マス計算

アプリ名に対応する各ディレクトリ上でそれぞれ以下のコマンドを実行することでjarファイルが作成されます。<br>
作成されたjarファイルと別途必要なjpgファイルやgifファイルを用意することでアプリが完成版として動作します。

```cmd
#Java8
javac *.java
jar cfm アプリ名.jar MANIFEST.MF -C . .
```
