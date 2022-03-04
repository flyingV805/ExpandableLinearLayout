[![](https://jitpack.io/v/flyingV805/ExpandableLinearLayout.svg)](https://jitpack.io/#flyingV805/ExpandableLinearLayout)

# ExpandableLinearLayout
LinearLayout for Android, with analog of Flutter's Expanded Widget

![Example ExpandableLinearLayout](https://github.com/flyingV805/ExpandableLinearLayout/blob/master/img/example.jpg| width=200 )

## Install

### Jitpack

Add Jitpack to your build file's list of repositories.

```groovy
repositories {
   maven { url 'https://jitpack.io' }
}
```

to use the Jitpack.IO Repository

```groovy
dependencies {
    ...
    implementation 'com.github.flyingV805:ExpandableLinearLayout:${version}'
    ...
}
```
replacing ${version} with the version you wish to use

## Usage

Add _xmlns:expanded="http://schemas.android.com/apk/res-auto"_ to your layout xml root.
You're now ready to use ExpandableLinearLayout! Just add to your layout xml:

    <kz.flyingv.expandablelinearlayout.ExpandableLinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal"
            expanded:expandedPosition="0">

            <androidx.appcompat.widget.AppCompatButton
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"/>

            <androidx.appcompat.widget.AppCompatButton
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"/>

    </kz.flyingv.expandablelinearlayout.ExpandableLinearLayout>

Then specify a child position, which you want to expand in the layout by using _expanded:expandedPosition="0"_
