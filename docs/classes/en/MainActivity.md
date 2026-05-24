# MainActivity Class Description

________________________________________
## 1. General Information
*   **Class Name:** `MainActivity`
*   **Type:** Activity
*   **App Purpose:** Main screen of the application. Acts as an entry point and navigation menu to demonstrate various custom interface elements.
*   **Interaction:** Launches other Activities (`DinamicSinus`, `AddCustomActionBar`, `MyToolbar`) and calls helper classes (`MyToast`, `AlertDialog`).

________________________________________
## 2. Variables (Class Fields)
| Name | Type | Purpose | Where is it used |
| :--- | :--- | :--- | :--- |
| `context` | `Context` | Holds a reference to the system environment. | Passed to Toast, Dialog, and Intent. |
| `bToast` | `Button` | Button to show a custom Toast. | `initComponents()`, `onCreate()` |
| `bDialog` | `Button` | Button to open a complex dialog. | `initComponents()`, `onCreate()` |
| `bSinus` | `Button` | Button to navigate to the sine graph. | `initComponents()`, `onCreate()` |
| `bActionBar` | `Button` | Button to navigate to custom ActionBar. | `initComponents()`, `onCreate()` |
| `bToolbar` | `Button` | Button to navigate to custom Toolbar. | `initComponents()`, `onCreate()` |

________________________________________
## 3. Class Methods

### Method: onCreate
*   **Type:** public
*   **Return Value:** void
*   **Parameters:**
    | Name | Type | Description |
    | :--- | :--- | :--- |
    | `savedInstanceState` | `Bundle` | Saved system state (if any). |
*   **What it does:**  
    1. Calls the parent method `super.onCreate`.
    2. Sets the interface layout `R.layout.activity_main`.
    3. Calls `initComponents()` to bind buttons.
    4. Assigns click listeners (`setOnClickListener`) to all buttons. When `bDialog` is clicked, a complex `AlertDialog` is created and displayed with input fields and action buttons (SMS, Email, etc.).
*   **When called:** When the system creates the activity.
*   **What is important to understand:** All initialization logic is concentrated here. Creating a dialog inside this method makes the code bulky; it would be better to move the dialog creation to a separate method.

### Method: initComponents
*   **Type:** private
*   **Return Value:** void
*   **Parameters:** none.
*   **What it does:**  
    Links Java variables with XML layout elements using `findViewById`. Also initializes `context` with `this`.
*   **When called:** Inside `onCreate`.
*   **What is important to understand:** Helps keep `onCreate` code cleaner.

________________________________________
## 4. Lifecycle
*   **onCreate():** Called first. This is where the screen "birth" happens: setting the design and binding buttons.

________________________________________
## 5. UI Interaction
*   **Elements:** Buttons, Text fields (`TextView`, `EditText` — inside the dialog).
*   **Connection:** Via `findViewById`.
*   **Events:** Click handling (`setOnClickListener`).

________________________________________
## 6. Interaction with Other Components
*   **Transitions:** Uses `Intent` to start `DinamicSinus`, `AddCustomActionBar`, `MyToolbar`.
*   **Data:** In the current code, no data is transferred between screens, only the launch event.

________________________________________
## 7. General Class Logic
The class works as a dispatcher. The user sees a list of buttons, each demonstrating a separate function of the application. Clicking either performs an action on the spot (Toast, Dialog) or opens a new screen.

**Usage Example:**
1. User launches the app.
2. Clicks the "Dialog" button.
3. A window appears asking for data.
4. User enters a number and clicks "Cancel" to exit the window.

________________________________________
## 8. Simplified Explanation
**Explanation in simple words:**  
Imagine `MainActivity` is the **main menu in a game**. You have buttons like "Start Game", "Settings", "Exit". Each button leads to its own section. `MainActivity` itself doesn't play the game; it only helps you choose the desired mode.

________________________________________
**Code Tip:**  
The `AlertDialog` creation logic is very large. It is recommended to move it to a separate method (e.g., `showContactDialog()`) to keep `onCreate` short and clear.
