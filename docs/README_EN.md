# 📱 Android Application Documentation: CustomDesignCollections

________________________________________
🧾 **General Information**

**Project Name:**  
CustomDesignCollections

**Author(s):**  
Zeev Fraiman

**Date:**  
May 2024

**Language:**  
Java

**Development Environment:**  
Android Studio

**Android Version (minSdk / targetSdk):**  
26 / 34
________________________________________
🎯 **Project Goal**
•	**What problem does the app solve:** It demonstrates the implementation of custom UI elements: Toast, Dialog, ActionBar, Toolbar, and graphical representations (Custom View).

•	**Why is this task important:** Standard Android components don't always match specific design or functional requirements. Knowing how to create custom components allows for a unique and interactive user interface.

•	**Target Audience:** Android developers looking to learn about Custom Views and deep UI customization.
________________________________________
📌 **Application Requirements**

**Functional Requirements**
•	Display custom notifications (Toast) with images.
•	Launch complex dialog windows with user-defined layouts.
•	Real-time dynamic rendering of a sine wave graph.
•	Demonstration of custom Toolbar and ActionBar implementations.

**Non-Functional Requirements**
•	**Performance:** Smooth graphic rendering (60 FPS for the sine wave).
•	**Usability:** Simple main screen interface for navigating to demo examples.
•	**Reliability:** Correct handling of Activity lifecycle during graphic redraws.
________________________________________
🧠 **General Architecture**
•	**Chosen Approach:**  
Standard Android Components (Activity-driven / View-oriented).

•	**Why it was chosen:**  
For a project focused on a UI library/examples, direct access to View and Activity is the most efficient way to demonstrate rendering and customization mechanisms.

•	**Main System Components:**  
MainActivity, Custom Views (CustomSinusView), Static Helper Classes (MyToast).
________________________________________
🧩 **UML Diagram**

[MainActivity] 
   |-- (Static Call) --> [MyToast]
   |-- (Intent) --> [DinamicSinus] --> [CustomSinusView]
   |-- (Intent) --> [AddCustomActionBar]
   |-- (Intent) --> [MyToolbar] --> [CustomToolbar]
________________________________________
**Package Explanation:**
- All classes are located in the `zeev.fraiman.customdesigncollections` package.
- This is justified for a small utility project where all components are closely related to the main theme — design customization.
________________________________________
🧩 **Detailed Class Description**

📌 **Class: MainActivity**
**Role:**  
Main screen of the application (Menu).

**Responsibility:**  
UI initialization and navigation through application sections.

**Main Methods:** 
- `onCreate()` — initializes buttons and sets event listeners.
- `initComponents()` — finds View elements by ID.

**Interaction with other classes:**  
Calls static methods of `MyToast`, starts `DinamicSinus`, `AddCustomActionBar`, `MyToolbar`.
________________________________________
📌 **Class: CustomSinusView**
**Role:**  
Custom graphical component.

**Why it is used:**  
To implement dynamic rendering of mathematical functions, which is not possible with standard Android tools.

**Main Methods:**
- `onDraw()` — logic for drawing the sine wave on the Canvas.
- `postInvalidateDelayed()` — creates an animation loop.
________________________________________
📌 **Class: MyToast**
**Role:**  
Utility class for UI.

**Responsibility:**  
Displays popup notifications with a custom Layout (text + icon).
________________________________________
🔄 **Application Workflow Diagram**

**Scenario (Viewing the graph):**
1. User clicks "Sinus" in MainActivity.
2. System launches DinamicSinus Activity.
3. DinamicSinus loads the layout with CustomSinusView.
4. CustomSinusView begins the drawing cycle via `onDraw`, gradually increasing the number of points displayed.
________________________________________
🎨 **UI/UX Analysis**
•	**Why the interface is designed this way:**  
The interface is as simple as possible (button menu) to not distract from the essence of each specific example.

•	**Principles used:**
–	**Simplicity:** Access to all functions in one click.
–	**Logicity:** Each example is moved to a separate screen or dialog.
–	**Accessibility:** Use of high-contrast colors and clear icons.

•	**What can be improved:**  
Add dark theme support and tablet optimization.
________________________________________
⚙️ **Threading**
**Description:** 
- Uses: `postInvalidateDelayed` (internal View mechanism for UI thread interaction).
- **Why this method was chosen:**  
Ensures drawing synchronization with the screen refresh rate without the need for manual thread management.

•	**Prevention of:**
–	**Hanging (ANR):** Drawing code is optimized, calculations are minimal.
–	**Memory Leaks:** Using application context in Toast and correctly finishing animations.
________________________________________
💾 **Data Management**
•	**Where data is stored:**  
Data is not stored (Stateless UI Demo).

•	**Why this method was chosen:**  
For design demonstration purposes, data storage is not required.
________________________________________
🌐 **Networking**
•	No networking in the current version.
________________________________________
🔐 **Security (Basic Level)**
•	The app does not handle sensitive information. Standard Android application sandbox protection is used.
________________________________________
🧪 **Testing**
•	**Test types:**  
Manual functional testing of all buttons and UI elements.
________________________________________
🐞 **Error Handling**
•	Null checks during View initialization.
•	Array bounds protection when drawing the sine wave.
________________________________________
⚡ **Performance**
•	**Optimizations:** Reusing `Paint` objects and pre-calculating sine wave points.
•	**Bottlenecks:** With an extremely large number of points (1000+), Canvas drawing might slow down on older devices.
________________________________________
🚀 **Expansion Possibilities**
•	Adding a custom animation library.
•	Integration with Material Design 3 (Material You).
•	Creating a library of custom buttons.
________________________________________
📊 **Project Self-Assessment**

| Criterion | Score (1–10) |
| :--- | :--- |
| Architecture | 8 |
| Code | 9 |
| UI/UX | 8 |
| Reliability | 10 |
| **Overall Level** | **9** |
________________________________________
🏁 **Conclusion**
•	**Best achievement:** Implementation of smooth sine wave animation.
•	**Difficulties encountered:** Fine-tuning the correct positioning in custom Dialogs.
•	**Skills acquired:** Deep understanding of `Canvas`, `Paint`, and `View` lifecycle.
________________________________________
📎 **Appendices**
•	**Screenshots:** (insert paths to images in the res folder)
•	**Repository:** [GitHub Link]
