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

```sh
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Step 2. Add the dependency

```sh
	 implementation 'com.github.GARPIX-Android:garpix_text_watchers:1.0.0'
```

## Example

```sh
val editText : EditText = findViewById(R.id.editText)
editText.addTextChangedListener(GarpixDateTextWatcher(editText))
```
```sh
val editText : EditText = findViewById(R.id.editText)
editText.addTextChangedListener(GarpixPassportTextWatcher(editText))
```
```sh
val editText : EditText = findViewById(R.id.editText)
editText.addTextChangedListener(GarpixPhoneTextWatcher(editText))
```
```sh
val editText : EditText = findViewById(R.id.editText)
val suffix : String = " km."
editText.addTextChangedListener(GarpixSuffixTextWatcher(editText, suffix ))
```
