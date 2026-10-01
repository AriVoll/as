БАЗОВЫЙ КАЛЬКУЛЯТОР — ANDROID STUDIO / KOTLIN

Как открыть:
1. Распакуйте ZIP.
2. В Android Studio выберите File -> Open.
3. Выберите папку BasicCalculator_Ready.
4. Дождитесь Gradle Sync.
5. Запустите приложение.

Структура:
app/src/main/java/com/example/calculator/MainActivity.kt
app/src/main/res/layout/activity_main.xml

В MainActivity.kt находится только Kotlin-код.
В activity_main.xml находится только XML-разметка.

Функции:
- цифры 0-9;
- +, -, *, /;
- =;
- общий обработчик цифр;
- ввод с клавиатуры;
- десятичная запятая без повторного ввода;
- первое число отображается в tv1;
- операция отображается в tv2;
- после = tv1 и tv2 очищаются;
- защита от деления на ноль.
