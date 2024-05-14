echo "Calling Open AI..."

MY_OPEN_AI_KEY="sk-proj-5OEb0dGKDe0kUbfzG6bET3BlbkFJVHrlFucwzryDg17PlCyJ"
PROMPT="What is the capital of France?"

curl https://api.openai.com/v1/chat/completions \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer $MY_OPEN_AI_KEY" \
  -d '{"model": "gpt-3.5-turbo-1106", "messages": [{"role": "system", "content": "You are a helpful assistant."}, {"role": "user", "content": "'"$PROMPT"'"}]}'