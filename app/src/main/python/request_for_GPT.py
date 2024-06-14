import openai
from openai import OpenAI

def gpt(word,extract):
    apikey = '################'

    # APIキーの設定
    openai.api_key = apikey
    
    prompt = "#命令 あなたの役職は「子供の質問に答える博士」です。下記の#単語について、#条件と#概要を考慮したうえでわかりやすく要約してください。 #単語 "+word+" #概要 "+extract+"#条件 出力は100字程度にしてください。曖昧な表現は断固拒否します。小学生3年生でも理解できる文で出力してください。わかりやすい例えも追加してください。語尾をですます調ではなく、「〇〇だよ」や「〇〇なんだ」にしてください。"
    model = "gpt-4o"
    response = openai.chat.completions.create(
        model=model,
        messages=[
        {"role": "user", "content": prompt},
        ]
    )
    print(response.choices[0].message.content)
    return response.choices[0].message.content