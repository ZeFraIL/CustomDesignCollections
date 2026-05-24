# CustomSinusView Class Description

________________________________________
## 1. General Information
*   **Class Name:** `CustomSinusView`
*   **Type:** Custom View
*   **App Purpose:** Rendering a dynamic sine wave graph. The class is responsible for the mathematical calculation of points and their visualization on the Canvas.
*   **Interaction:** Used inside an Activity (e.g., `DinamicSinus`) as a regular visual element.

________________________________________
## 2. Variables (Class Fields)
| Name | Type | Purpose | Where is it used |
| :--- | :--- | :--- | :--- |
| `paint` | `Paint` | Drawing tool (color, line thickness). | `init()`, `onDraw()` |
| `pointsCount` | `int` | Number of points in the graph (100). | `init()`, `onDraw()` |
| `xPoints` | `float[]` | Array of X coordinates for the graph. | `init()`, `onDraw()` |
| `yPoints` | `float[]` | Array of Y coordinates for the graph. | `init()`, `onDraw()` |
| `currentPoint` | `int` | Current rendered point counter (for animation). | `onDraw()` |
| `duration` | `long` | Total animation duration (10 sec). | `onDraw()` |
| `startTime` | `long` | Animation start time. | `init()`, `onDraw()` |

________________________________________
## 3. Class Methods

### Method: init
*   **Type:** private
*   **Return Value:** void
*   **What it does:**  
    Sets up the brush (`paint`): blue color, thickness 5, style "stroke". Also pre-calculates sine values for 100 points and stores them in arrays.
*   **When called:** In constructors when the object is created.

### Method: onDraw
*   **Type:** protected
*   **Return Value:** void
*   **Parameters:** `Canvas canvas` (Canvas for drawing).
*   **What it does:**  
    1. Calculates the graph scale based on screen dimensions (`width`, `height`).
    2. Draws lines between points from 0 to `currentPoint`.
    3. Calculates time progress. If 10 seconds haven't passed, it increases `currentPoint`.
    4. Calls `postInvalidateDelayed(100)`, which forces the system to redraw the screen after 0.1 seconds. This creates the animation effect.
*   **When called:** Automatically by the system when drawing is needed.

________________________________________
## 5. UI Interaction
The class itself is a UI element. It doesn't use buttons; it "draws" itself on the screen.

________________________________________
## 7. General Class Logic
Upon creation, the class calculates the sine shape. Then it starts "gradually" showing this shape, drawing one point every 100 milliseconds.

________________________________________
## 8. Simplified Explanation
**Explanation in simple words:**  
Imagine an artist drawing a picture. But instead of showing everything at once, they draw one line every few seconds while you watch. `CustomSinusView` is such a digital mathematical artist.

________________________________________
**Code Tip:**  
In the `onDraw` method, local variables `width` and `height` are created. This is fine, but calculating `xScale` and `yScale` could be moved to `onSizeChanged` to avoid recalculating them on every animation frame.
