# Live Update Notification Android

[![Linktree](https://img.shields.io/badge/linktree-1de9b6?style=for-the-badge&logo=linktree&logoColor=white)](https://linktr.ee/nicos_nicolaou)
[![Static Badge](https://img.shields.io/badge/Site-blue?style=for-the-badge&label=Web)](https://nicosnicolaou16.github.io/)
[![X](https://img.shields.io/badge/X-%23000000.svg?style=for-the-badge&logo=X&logoColor=white)](https://twitter.com/nicolaou_nicos)
[![LinkedIn](https://img.shields.io/badge/linkedin-%230077B5.svg?style=for-the-badge&logo=linkedin&logoColor=white)](https://linkedin.com/in/nicos-nicolaou-a16720aa)
[![Medium](https://img.shields.io/badge/Medium-12100E?style=for-the-badge&logo=medium&logoColor=white)](https://medium.com/@nicosnicolaou)
[![Mastodon](https://img.shields.io/badge/-MASTODON-%232B90D9?style=for-the-badge&logo=mastodon&logoColor=white)](https://androiddev.social/@nicolaou_nicos)
[![Bluesky](https://img.shields.io/badge/Bluesky-0285FF?style=for-the-badge&logo=Bluesky&logoColor=white)](https://bsky.app/profile/nicolaounicos.bsky.social)
[![Dev.to blog](https://img.shields.io/badge/dev.to-0A0A0A?style=for-the-badge&logo=dev.to&logoColor=white)](https://dev.to/nicosnicolaou16)
[![YouTube](https://img.shields.io/badge/YouTube-%23FF0000.svg?style=for-the-badge&logo=YouTube&logoColor=white)](https://www.youtube.com/@nicosnicolaou16)
[![Static Badge](https://img.shields.io/badge/Developer_Profile-blue?style=for-the-badge&label=Google)](https://g.dev/nicolaou_nicos)

This repository provides a working example of implementing Live Update Notifications on Android 16 (
Android U). It demonstrates how to leverage both Firebase Cloud Messaging (FCM) and local
notifications to deliver rich, timely updates to the user.

# Examples

<p align="left">
  <a title="simulator_image"><img src="examples/Screenshot_20250608_203141.png" height="500" width="200"></a>
  <a title="simulator_image"><img src="examples/Screenshot_20250608_202552.png" height="500" width="200"></a>
  <a title="simulator_image"><img src="examples/Screenshot_20250608_203127.png" height="500" width="200"></a>
  <a title="simulator_image"><img src="examples/example_gif1.gif" height="500" width="200"></a>
</p>

# 🚀 Features

- 🔔 Live Notifications support on Android 16
- ☁️ Firebase Cloud Messaging integration
- 📦 Payload handling and dynamic content updates
- 📱 Local notification example to simulate live updates without a backend
- 💡 Best practices for targeting Android 16+ notification behavior

# 📦 What’s Inside

- Sample app written in Kotlin
- Firebase integration (with sample payload format)
- Notification channel setup and management
- Code examples to create/update live notifications

# 🔧 Requirements

- Target SDK 36 (Android 16)
- Firebase project (for push notifications)

# 📚 Getting Started

### 1️⃣ Clone the Repository <br />

### 2️⃣ Set Up Firebase

- Go to Firebase Console and create a new project (or use an existing one).
- Add an Android app to the Firebase project using your app’s package name.
    - 💡 Tip: You can change the application ID (package name) in build.gradle to match your
      preferred namespace (e.g., com.yourname.app).
- Download the google-services.json file and place it in the /app directory.
- Enable Firebase Cloud Messaging (FCM) in the Firebase Console under Build > Cloud Messaging.
- Launch the app and tap the "Get FCM Token" button:
    - The token will be shown in a toast and logged in Logcat
    - Copy this token for sending test messages

### 3️⃣ Run the App

- Connect a physical device or use an emulator running Android 16
- Press Run in Android Studio to build and install the app

### 4️⃣ Test Live Notifications <br />

🔹 Option A: Test with Local Notification

- Tap the "Send Local Notification" button in the app
- It creates a live progress notification based on a local NotificationModel instance

🔹 Option B: Test with Firebase Console

- Go to Firebase Console > Cloud Messaging > Send Your First Message
- Enter a title and body (these will be overridden by data payload)
- Open Advanced options → Data
- In the Target section, select Single Device
- Paste the FCM token from the app
- Add the following key-value pairs:

### 📝 Example FCM Payload

```json
{
  "title": "Live Update Remote Title",
  "body": "Live Update Remote Body",
  "currentProgress": "80",
  "currentProgressSegmentOne": "33",
  "currentProgressSegmentTwo": "33",
  "currentProgressSegmentThree": "33",
  "currentProgressSegmentFour": "33",
  "currentProgressPointOne": "33",
  "currentProgressPointTwo": "66",
  "currentProgressPointThree": "99"
}

```

- Click Send Message

  📌 The payload demonstrates segmented and point-based progress tracking in a live notification,
  perfect for use cases like order tracking, fitness goals, or download status.

# Firebase Cloud Messaging (Example)

<p align="left">
  <a title="simulator_image"><img src="examples/Screenshot 2025-06-08 192944.png" height="600" width="777"></a>
</p>

> [!IMPORTANT]  
> Check my article for the setup :point_right: [Implementing Live Update Notifications in Android 16 - Medium](https://medium.com/@nicosnicolaou/implementing-live-update-notifications-in-android-16-7c962ec6c373) :point_left: <br />

# 🔧 Versioning

Target SDK version: 37 <br />
Minimum SDK version: 29 <br />
Kotlin version: 2.4.10 <br />
Gradle version: 9.3.1 <br />

# 📚 References

-   [Android 16: Progress-centric notifications](https://developer.android.com/about/versions/16/features/progress-centric-notifications)
-   [Official Sample: Live Updates on GitHub](https://github.com/android/platform-samples/tree/main/samples/user-interface/live-updates)
-   [Documentation: Update a notification](https://developer.android.com/develop/ui/views/notifications/build-notification#Updating)

## ⭐ Stargazers

If you enjoy this project, please give it a star!
Check out all the stargazers
here: [Stargazers on GitHub](https://github.com/NicosNicolaou16/Live_Update_Notifcation_Android/stargazers)

## 🙏 Support & Contributions

This project is actively maintained. Feedback, bug reports, and feature requests are welcome! Please feel free to **open an issue** or submit a **pull request**.