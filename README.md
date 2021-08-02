# Garpix Text Watchers
## Android Text Watchers for date, passport, phone, suffix

Provides convenient conversion of strings to the required format

## Requirements

minSdkVersion 23 (Android 6.0 MarshMallow)

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
val editText : EditText = *your initialization*
editText.addTextChangedListener(GarpixDateTextWatcher(editText))
```
