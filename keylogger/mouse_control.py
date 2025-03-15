from pynput.mouse import Listener

def print_coordinates(x,y):
    print(f"Mouse at: {x,y}")

with Listener(on_move=print_coordinates) as l:
    l.join()
