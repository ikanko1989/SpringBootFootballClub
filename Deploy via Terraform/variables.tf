variable "aws_region" {
  description = "AWS region to deploy resources"
  default     = "us-east-1"
}

variable "key_pair_name" {
  description = "The name of the existing EC2 key pair to use"
  type        = string
}

variable "public_key_path" {
  description = "Path to your SSH public key"
  type        = string
  default     = "~/.ssh/id_rsa.pub"
}

variable "instance_type" {
  description = "EC2 instance type"
  default     = "t2.micro"
}

variable "ami_id" {
  description = "AMI ID for EC2 instance"
  default     = "ami-0c02fb55956c7d316" # Amazon Linux 2 in us-east-1
}

variable "github_repo" {
  description = "GitHub repository URL to clone"
  default     = "https://github.com/ikanko1989/SpringBootFootballClub.git"
}
