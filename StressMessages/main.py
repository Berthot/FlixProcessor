import time
import random
import string
import requests

url = 'http://localhost:9001/api/webapi'
send_total_messages: int = 100


class Helper:
    def __init__(self):
        self._source = ["Netflix", "TikTok", "Spotify", "9GAG"]
        self._user_source = [1, 2, 3, 4, 5]

    @staticmethod
    def generate_random_string(text_len: int = 8):
        letters = string.ascii_lowercase
        result_str = ''.join(random.choice(letters) for _ in range(text_len))
        return result_str

    def get_example(self):
        return {
            "data": f'{self.generate_random_string().upper()}',
            "source": f"{random.choice(self._source)}",
            "userId": int(random.choice(self._user_source)),
        }


if __name__ == '__main__':
    helper = Helper()
    for i in range(0, send_total_messages):
        time.sleep(0.9)
        json = helper.get_example()
        x = requests.post(url, json=json)
        print(json)
