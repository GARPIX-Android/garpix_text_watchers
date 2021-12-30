# Garpix Text Watchers
## Android Text Watchers for date, passport, phone, suffix

Provides convenient conversion of strings to the required format

## Requirements

minSdkVersion 23 (Android 6.0 MarshMallow)

## Features

- GarpixPhoneTextWatcher: converts the string in EditText to "+7 (999) 999-99-99"
- GarpixDateTextWatcher: converts the string in EditText to "12.12.2020"
- GarpixPassportTextWatcher: converts the string in EditText to "1234 567890"
- GarpixSuffixTextWatcher: adding needed suffix to end of string in EditText.

## Install

Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

```groovy
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Step 2. Add the dependency

```groovy
	 implementation 'com.github.GARPIX-Android:garpix_text_watchers:1.0.0'
```

## Usage

```kotlin
val editText : EditText = findViewById(R.id.editText)
editText.addTextChangedListener(GarpixDateTextWatcher(editText))
```
```kotlin
val editText : EditText = findViewById(R.id.editText)
editText.addTextChangedListener(GarpixPassportTextWatcher(editText))
```
```kotlin
val editText : EditText = findViewById(R.id.editText)
editText.addTextChangedListener(GarpixPhoneTextWatcher(editText))
```
```kotlin
val editText : EditText = findViewById(R.id.editText)
val suffix : String = " km."
editText.addTextChangedListener(GarpixSuffixTextWatcher(editText, suffix ))
```

## License

```sh
MIT License

Copyright (c) 2021 GARPIX-Android

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
