# soroban-classroom-app

このリポジトリでは、[私のWebサイト](https://www.resufactory.net/)で紹介している[そろばん教室アプリ](https://www.resufactory.net/yuza/?p=117)のソースコードを一時的に公開しています。

アプリの完成版とインストール手順を含めたzipファイルは[Googleドライブ](https://drive.google.com/file/d/1-ixNmLe1P8_29NK-4mRvHs6dXiQ1gIMI/view?usp=sharing)上で公開しています。<br>
・zipファイルのパスワード
```cmd
X@Jf+2V9EAEYKQTj
```

7つのアプリがあり対応する各ディレクトリ上でそれぞれ以下のコマンドを実行することでjarファイルが作成されます。<br>
作成されたjarファイルと別途必要なjpgファイルやgifファイルを用意することでアプリが完成版として動作します。

```cmd
javac *.java #Java8
jar cfm アプリ名.jar MANIFEST.MF -C . .
```
