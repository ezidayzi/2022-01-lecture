# Talking to the Server using a Bare Socket (not as HTTP request)
import socket
import ssl
from urllib.parse import quote_plus

request_text = """\
GET /search?q={}&format=json HTTP/1.1\r\n\
Host: nominatim.openstreetmap.org\r\n\
User-Agent: Foundations of Python Network Programming example search4.py\r\n\
Connection: close\r\n\
\r\n\
"""

def geocode(address):
    unencrypted_sock = socket.socket() # 소켓 생성
    unencrypted_sock.connect(('nominatim.openstreetmap.org', 443)) # IP 주소, 포트 넘버
    sock = ssl.wrap_socket(unencrypted_sock) # ssl 사용
    request = request_text.format(quote_plus(address)) # HTTP request 생성
    sock.sendall(request.encode('ascii')) # Request
    raw_reply = b'' # data type: byte
    while True:
        more = sock.recv(4096) # 포트 넘버 4096애 바이트 받기
        if not more:
            break
        raw_reply += more
    print(raw_reply.decode('utf-8')) # 디코딩 타입

if __name__ == '__main__':
    geocode('207 N. Defiance St, Archbold, OH')