interface UserProfile {
  id: number;
  name: string;
  email?: string;
}

type UserPreview = Pick<UserProfile, "id" | "name">;
type UserPatch = Partial<UserProfile>;

const preview: UserPreview = { id: 1, name: "Hoa" };
const patch: UserPatch = { email: "hoa@example.com" };

console.log({ preview, patch });
