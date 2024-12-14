import numpy as np
import matplotlib.pyplot as plt

# Define the x range, avoiding the discontinuities at odd multiples of π/2
x = np.linspace(-2 * np.pi, 2 * np.pi, 1000)
y = np.tan(x)

# Masking values where cos(x) = 0 to avoid plotting vertical asymptotes
y = np.ma.masked_where(np.abs(np.cos(x)) < 1e-10, y)

# Plotting
plt.figure(figsize=(10, 6))
plt.plot(x, y, label=r"$y = \frac{\sin(x)}{\cos(x)}$", color="blue")
plt.ylim(-10, 10)  # Limiting y-axis for clarity

# Adding vertical asymptotes
for i in range(-2, 3):  # Plot for multiples of pi/2 within the x range
    plt.axvline(x=(np.pi / 2) * i, color="red", linestyle="--", linewidth=0.5)

plt.title("Plot of y = sin(x) / cos(x)")
plt.xlabel("x")
plt.ylabel("y")
plt.grid(True)
plt.legend()
plt.show()
