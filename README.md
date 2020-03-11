# CodeStar Human Notifications

Listens to CodeStar Notifications and republish them in a human-friendly format

```shell
serverless deploy \
  --region eu-east-1 \
  --account $(aws sts get-caller-identity | jq -r .Account) \
  --bucket my-amazing-s3-bucket \
  --codestarSnsTopicArn arn:aws:sns:us-west-2:$(aws sts get-caller-identity | jq -r .Account):codecommit-notifications
  --stage sandbox
```
